package ncu.im3069.demo.app;

import java.sql.*;
import java.time.LocalDateTime;
import org.json.*;

import ncu.im3069.demo.util.DBMgr;

/**
 * The Class AppointmentHelper
 * AppointmentHelper類別（class）主要管理所有與Appointment相關與資料庫之方法（method）
 */

public class AppointmentHelper {

    /**
     * 實例化（Instantiates）一個新的（new）AppointmentHelper物件<br>
     * 採用Singleton不需要透過new
     */
    private AppointmentHelper() {

    }

    /** 靜態變數，儲存AppointmentHelper物件 */
    private static AppointmentHelper aph;

    private UserHelper uh;

    /** 儲存JDBC資料庫連線 */
    private Connection conn = null;

    /** 儲存JDBC預準備之SQL指令 */
    private PreparedStatement pres = null;

    /**
     * 靜態方法<br>
     * 實作Singleton（單例模式），僅允許建立一個AppointmentHelper物件
     * 
     * @return the helper 回傳AppointmentHelper物件
     */
    public static AppointmentHelper getHelper() {
        /** Singleton檢查是否已經有AppointmentHelper物件，若無則new一個，若有則直接回傳 */
        if (aph == null)
            aph = new AppointmentHelper();

        return aph;
    }

    /**
     * 透過身分證字號編號（ID）刪除預約資料
     * 
     * @return the JSONObject 回傳SQL執行結果
     */
    public JSONObject cancel(String user_id, int doctor_id) {
        /** 記錄實際執行之SQL指令 */
        String exexcute_sql = "";
        /** 紀錄程式開始執行時間 */
        long start_time = System.nanoTime();
        /** 紀錄SQL總行數 */
        int row = 0;
        /** 儲存JDBC檢索資料庫後回傳之結果，以 pointer 方式移動到下一筆資料 */
        ResultSet rs = null;

        try {
            /** 取得資料庫之連線 */
            conn = DBMgr.getConnection();

            /** SQL指令 */
            String sql = "DELETE FROM `appointment` WHERE `user_id` = ? and `doctor_id` = ? LIMIT 1";

            /** 將參數回填至SQL指令當中 */
            pres = conn.prepareStatement(sql);
            pres.setString(1, user_id);
            pres.setInt(2, doctor_id);
            /** 執行刪除之SQL指令並記錄影響之行數 */
            row = pres.executeUpdate();

            /** 紀錄真實執行的SQL指令，並印出 **/
            exexcute_sql = pres.toString();
            System.out.println(exexcute_sql);

        } catch (SQLException e) {
            /** 印出JDBC SQL指令錯誤 **/
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            /** 若錯誤則印出錯誤訊息 */
            e.printStackTrace();
        } finally {
            /** 關閉連線並釋放所有資料庫相關之資源 **/
            DBMgr.close(rs, pres, conn);
        }

        /** 紀錄程式結束執行時間 */
        long end_time = System.nanoTime();
        /** 紀錄程式執行時間 */
        long duration = (end_time - start_time);

        /** 將SQL指令、花費時間與影響行數，封裝成JSONObject回傳 */
        JSONObject response = new JSONObject();
        response.put("sql", exexcute_sql);
        response.put("row", row);
        response.put("time", duration);

        return response;
    }

    /**
     * 取回所有預約資料
     * 
     * @return the JSONObject 回傳SQL執行結果與自資料庫取回之所有資料
     */
    public JSONObject getAll() {
        /** 新建一個 Appointment 物件之 ap 變數，用於紀錄每一位查詢回之預約資料 */
        Appointment ap = null;
        /** 用於儲存所有檢索回之預約資訊，以JSONArray方式儲存 */
        JSONArray jsa = new JSONArray();
        /** 記錄實際執行之SQL指令 */
        String exexcute_sql = "";
        /** 紀錄程式開始執行時間 */
        long start_time = System.nanoTime();
        /** 紀錄SQL總行數 */
        int row = 0;
        /** 儲存JDBC檢索資料庫後回傳之結果，以 pointer 方式移動到下一筆資料 */
        ResultSet rs = null;

        try {
            /** 取得資料庫之連線 */
            conn = DBMgr.getConnection();
            /** SQL指令 */
            String sql = "SELECT * FROM `hospital`.`appointment`";

            /** 將參數回填至SQL指令當中，若無則不用只需要執行 prepareStatement */
            pres = conn.prepareStatement(sql);
            /** 執行查詢之SQL指令並記錄其回傳之資料 */
            rs = pres.executeQuery();

            /** 紀錄真實執行的SQL指令，並印出 **/
            exexcute_sql = pres.toString();
            System.out.println(exexcute_sql);

            /** 透過 while 迴圈移動pointer，取得每一筆回傳資料 */
            while (rs.next()) {
                /** 每執行一次迴圈表示有一筆資料 */
                row += 1;

                /** 將 ResultSet 之資料取出 */
                int seq = rs.getInt("appointment_seq");
                int doctor_id = rs.getInt("doctor_id");
                String user_id = rs.getString("user_id");
                String reserve_time = rs.getString("reserve_time");
                int appointment_number = rs.getInt("appointment");

                /** 將每一筆預約資料產生一個新Appointment物件 */
                ap = new Appointment(seq, doctor_id, user_id, reserve_time, appointment_number);
                /** 取出該預約資料並封裝至 JSONsonArray 內 */
                jsa.put(ap.getData());
            }

        } catch (SQLException e) {
            /** 印出JDBC SQL指令錯誤 **/
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            /** 若錯誤則印出錯誤訊息 */
            e.printStackTrace();
        } finally {
            /** 關閉連線並釋放所有資料庫相關之資源 **/
            DBMgr.close(rs, pres, conn);
        }

        /** 紀錄程式結束執行時間 */
        long end_time = System.nanoTime();
        /** 紀錄程式執行時間 */
        long duration = (end_time - start_time);

        /** 將SQL指令、花費時間、影響行數與所有門診資料之JSONArray，封裝成JSONObject回傳 */
        JSONObject response = new JSONObject();
        response.put("sql", exexcute_sql);
        response.put("row", row);
        response.put("time", duration);
        response.put("data", jsa);

        return response;
    }

    /**
     * 透過身分證字號（ID）取得預約資料
     * 
     * @return the JSON object 回傳SQL執行結果與該身分證字號之預約資料
     */
    public JSONObject getAppointmentByID(String id) {
        /** 用於儲存所有檢索回之預約資訊，以JSONArray方式儲存 */
        JSONArray jsa = new JSONArray();
        Appointment ap = null;
        /** 記錄實際執行之SQL指令 */
        String exexcute_sql = "";
        /** 紀錄程式開始執行時間 */
        long start_time = System.nanoTime();
        /** 紀錄SQL總行數 */
        int row = 0;
        /** 儲存JDBC檢索資料庫後回傳之結果，以 pointer 方式移動到下一筆資料 */
        ResultSet rs = null;

        try {
            /** 取得資料庫之連線 */
            conn = DBMgr.getConnection();
            /** SQL指令 */
            String sql = "SELECT * FROM `appointment` WHERE `user_id` = ?";

            /** 將參數回填至SQL指令當中，若無則不用只需要執行 prepareStatement */
            pres = conn.prepareStatement(sql);
            pres.setString(1, id);
            /** 執行查詢之SQL指令並記錄其回傳之資料 */
            rs = pres.executeQuery();

            /** 紀錄真實執行的SQL指令，並印出 **/
            exexcute_sql = pres.toString();
            System.out.println(exexcute_sql);

            /** 透過 while 迴圈移動pointer，取得每一筆回傳資料 */
            while (rs.next()) {
                /** 每執行一次迴圈表示有一筆資料 */
                row += 1;

                /** 將 ResultSet 之資料取出 */
                int seq = rs.getInt("appointment_seq");
                int doctor_id = rs.getInt("doctor_id");
                String user_id = rs.getString("user_id");
                String reserve_time = rs.getString("reserve_time");
                int appointment_number = rs.getInt("appointment");
                
                String doctor_name = "";
                int dept_id = 0;
                //利用預約資料表中的doctor_id在醫生資料表中查找對應doctor_name
                String doctor_name_sql = "SELECT `doctor_name`, `dept_id` FROM `doctor` WHERE `doctor_id` = ? LIMIT 1";
                pres = conn.prepareStatement(doctor_name_sql);
                pres.setInt(1, doctor_id);
                ResultSet doctor_rs = pres.executeQuery();
                
                while (doctor_rs.next()) {
                	doctor_name = doctor_rs.getString("doctor_name");
                	dept_id = doctor_rs.getInt("dept_id");
                }
                
                String dept_name = "";
                //利用醫生資料表中的dept_id在科別資料表中查找對應dept_name
                String dept_name_spl = "SELECT `dept_name` FROM `department` WHERE `dept_id` = ? LIMIT 1";
                pres = conn.prepareStatement(dept_name_spl);
                pres.setInt(1, dept_id);
                ResultSet dept_rs = pres.executeQuery();
                
                while (dept_rs.next()) {
                	dept_name = dept_rs.getString("dept_name");
                }
                
                
                /** 將每一筆預約資料產生一名新Appointment物件 */
                ap = new Appointment(seq, doctor_id, user_id, reserve_time, appointment_number, dept_name, doctor_name);
                /** 取出該項預約資料並封裝至 JSONsonArray 內 */
                jsa.put(ap.getData());
            }

        } catch (SQLException e) {
            /** 印出JDBC SQL指令錯誤 **/
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            /** 若錯誤則印出錯誤訊息 */
            e.printStackTrace();
        } finally {
            /** 關閉連線並釋放所有資料庫相關之資源 **/
            DBMgr.close(rs, pres, conn);
        }

        /** 紀錄程式結束執行時間 */
        long end_time = System.nanoTime();
        /** 紀錄程式執行時間 */
        long duration = (end_time - start_time);

        /** 將SQL指令、花費時間、影響行數與所有門診資料之JSONArray，封裝成JSONObject回傳 */

        JSONObject response = new JSONObject();
        response.put("sql", exexcute_sql);
        response.put("row", row);
        response.put("time", duration);
        response.put("data", jsa);

        return response;
    }

    public int getAppointment(Appointment ap) {
        /** 紀錄SQL總行數，若為「-1」代表資料庫檢索尚未完成 */
        int row = -1;
        /** 儲存JDBC檢索資料庫後回傳之結果，以 pointer 方式移動到下一筆資料 */
        ResultSet rs = null;

        try {
            /** 取得資料庫之連線 */
            conn = DBMgr.getConnection();
            /** SQL指令 */
            String sql = "SELECT count(*) FROM `appoint` WHERE `doctor_id` = ? and `reserve_time` = ?";

            /** 取得所需之參數 */
            int dcotor_id = ap.getDoctorID();
            String reserve_time = ap.getReserveTime();

            /** 將參數回填至SQL指令當中 */
            pres = conn.prepareStatement(sql);
            pres.setInt(1, dcotor_id);
            pres.setString(2, reserve_time);
            /** 執行查詢之SQL指令並記錄其回傳之資料 */
            rs = pres.executeQuery();

            /** 讓指標移往最後一列，取得目前有幾行在資料庫內 */
            rs.next();
            row = rs.getInt("count(*)");
            System.out.print(row);

        } catch (SQLException e) {
            /** 印出JDBC SQL指令錯誤 **/
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            /** 若錯誤則印出錯誤訊息 */
            e.printStackTrace();
        } finally {
            /** 關閉連線並釋放所有資料庫相關之資源 **/
            DBMgr.close(rs, pres, conn);
        }

        return row + 1;
    }

    public boolean checkDuplicate(Appointment ap) {
        /** 紀錄SQL總行數，若為「-1」代表資料庫檢索尚未完成 */
        int row = -1;
        /** 儲存JDBC檢索資料庫後回傳之結果，以 pointer 方式移動到下一筆資料 */
        ResultSet rs = null;

        try {
            /** 取得資料庫之連線 */
            conn = DBMgr.getConnection();
            /** SQL指令 */
            String sql = "SELECT count(*) FROM `appointment` WHERE `user_id` = ? AND `doctor_id` = ?";

            /** 取得所需之參數 */
            String user_id = ap.getUserID();
            int doctor_id = ap.getDoctorID();

            /** 將參數回填至SQL指令當中 */
            pres = conn.prepareStatement(sql);
            pres.setString(1, user_id);
            pres.setInt(2, doctor_id);
            /** 執行查詢之SQL指令並記錄其回傳之資料 */
            rs = pres.executeQuery();

            /** 讓指標移往最後一列，取得目前有幾行在資料庫內 */
            rs.next();
            row = rs.getInt("count(*)");
            System.out.print(row);

        } catch (SQLException e) {
            /** 印出JDBC SQL指令錯誤 **/
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            /** 若錯誤則印出錯誤訊息 */
            e.printStackTrace();
        } finally {
            /** 關閉連線並釋放所有資料庫相關之資源 **/
            DBMgr.close(rs, pres, conn);
        }

        /**
         * 判斷是否已經有一筆該身分證字號之資料
         * 若無一筆則回傳False，否則回傳True
         */
        return (row == 0) ? false : true;
    }

    /**
     * 建立預約資料至資料庫
     * 
     * @return the JSON object 回傳SQL指令執行之結果
     */
    public JSONObject create(Appointment ap) {
        /** 記錄實際執行之SQL指令 */
        String exexcute_sql = "";
        /** 紀錄程式開始執行時間 */
        long start_time = System.nanoTime();
        /** 紀錄SQL總行數 */
        int row = 0;

        try {
            /** 取得資料庫之連線 */
            conn = DBMgr.getConnection();
            /** SQL指令 */
            String sql = "INSERT INTO `appointment`(`doctor_id`, `user_id`, `reserve_time`, `appointment`)"
                    + " VALUES(?, ?, ?, ?, ?)";

            /** 取得所需之參數 */
            // int appointment_seq = ap.getSeq();
            int doctor_id = ap.getDoctorID();
            String user_id = ap.getUserID();
            String reserve_time = ap.getReserveTime();
            int appointment_number = getAppointment(ap);

            /** 將參數回填至SQL指令當中 */
            pres = conn.prepareStatement(sql);
            // pres.setInt(1, appointment_seq);
            pres.setInt(1, doctor_id);
            pres.setString(2, user_id);
            pres.setString(3, reserve_time);
            pres.setInt(4, appointment_number);

            /** 執行新增之SQL指令並記錄影響之行數 */
            row = pres.executeUpdate();

            /** 紀錄真實執行的SQL指令，並印出 **/
            exexcute_sql = pres.toString();
            System.out.println(exexcute_sql);

        } catch (SQLException e) {
            /** 印出JDBC SQL指令錯誤 **/
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            /** 若錯誤則印出錯誤訊息 */
            e.printStackTrace();
        } finally {
            /** 關閉連線並釋放所有資料庫相關之資源 **/
            DBMgr.close(pres, conn);
        }

        /** 紀錄程式結束執行時間 */
        long end_time = System.nanoTime();
        /** 紀錄程式執行時間 */
        long duration = (end_time - start_time);

        /** 將SQL指令、花費時間與影響行數，封裝成JSONObject回傳 */
        JSONObject response = new JSONObject();
        response.put("sql", exexcute_sql);
        response.put("time", duration);
        response.put("row", row);

        return response;
    }

    /**
     * 修改預約資料
     * 
     * @return the JSONObject 回傳SQL指令執行結果與執行之資料
     */
    public JSONObject update(Appointment ap) {
        /** 紀錄回傳之資料 */
        JSONArray jsa = new JSONArray();
        /** 記錄實際執行之SQL指令 */
        String exexcute_sql = "";
        /** 紀錄程式開始執行時間 */
        long start_time = System.nanoTime();
        /** 紀錄SQL總行數 */
        int row = 0;

        try {
            /** 取得資料庫之連線 */
            conn = DBMgr.getConnection();
            /** SQL指令 */
            String sql = "Update `appointment` SET `reserve_time` = ? ,`appointment` = ? WHERE `user_id` = ? and `doctor_id` = ?";
            /** 取得所需之參數 */
            String user_id = ap.getUserID();
            int doctor_id = ap.getDoctorID();
            String reserve_time = ap.getReserveTime();
            int appointment_number = getAppointment(ap);

            /** 將參數回填至SQL指令當中 */
            pres = conn.prepareStatement(sql);
            pres.setString(1, reserve_time);
            pres.setInt(2, appointment_number);
            pres.setString(3, user_id);
            pres.setInt(4, doctor_id);
            /** 執行更新之SQL指令並記錄影響之行數 */
            row = pres.executeUpdate();

            /** 紀錄真實執行的SQL指令，並印出 **/
            exexcute_sql = pres.toString();
            System.out.println(exexcute_sql);

        } catch (SQLException e) {
            /** 印出JDBC SQL指令錯誤 **/
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            /** 若錯誤則印出錯誤訊息 */
            e.printStackTrace();
        } finally {
            /** 關閉連線並釋放所有資料庫相關之資源 **/
            DBMgr.close(pres, conn);
        }

        /** 紀錄程式結束執行時間 */
        long end_time = System.nanoTime();
        /** 紀錄程式執行時間 */
        long duration = (end_time - start_time);

        /** 將SQL指令、花費時間與影響行數，封裝成JSONObject回傳 */
        JSONObject response = new JSONObject();
        response.put("sql", exexcute_sql);
        response.put("row", row);
        response.put("time", duration);
        response.put("data", jsa);

        return response;
    }

}
