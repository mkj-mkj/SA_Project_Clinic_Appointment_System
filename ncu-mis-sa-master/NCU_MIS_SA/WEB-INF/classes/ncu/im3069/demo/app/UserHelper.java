package ncu.im3069.demo.app;

import java.sql.*;
import java.time.LocalDateTime;
import org.json.*;

import ncu.im3069.demo.util.DBMgr;

/**
 * The Class UserHelper
 * UserHelper類別（class）主要管理所有與Member相關與資料庫之方法（method）
 */

public class UserHelper {

    /**
     * 實例化（Instantiates）一個新的（new）UserHelper物件
     * 採用Singleton不需要透過new
     */
    private UserHelper() {

    }

    /** 靜態變數，儲存UserHelper物件 */
    private static UserHelper uh;

    /** 儲存JDBC資料庫連線 */
    private Connection conn = null;

    /** 儲存JDBC預準備之SQL指令 */
    private PreparedStatement pres = null;

    /**
     * 靜態方法
     * 實作Singleton（單例模式），僅允許建立一個UserHelper物件
     *
     * @return the helper 回傳UserHelper物件
     */
    public static UserHelper getHelper() {
        /** Singleton檢查是否已經有UserHelper物件，若無則new一個，若有則直接回傳 */
        if (uh == null)
            uh = new UserHelper();

        return uh;
    }

    /**
     * 透過身分證字號（ID）刪除使用者
     * 
     * @return the JSONObject 回傳SQL執行結果
     */
    public JSONObject deleteByID(String id) {
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
            String sql = "DELETE FROM `hospital`.`user` WHERE `user_id` = ? LIMIT 1";

            /** 將參數回填至SQL指令當中 */
            pres = conn.prepareStatement(sql);
            pres.setString(1, id);
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
     * 取回所有使用者資料
     * 
     * @return the JSONObject 回傳SQL執行結果與自資料庫取回之所有資料
     */
    public JSONObject getAll() {
        /** 新建一個 User 物件之 u 變數，用於紀錄每一位查詢回之使用者資料 */
        User u = null;
        /** 用於儲存所有檢索回之使用者，以JSONArray方式儲存 */
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
            String sql = "SELECT * FROM `hospital`.`user`";

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
                String user_id = rs.getString("user_id");
                int case_number = rs.getInt("case_number");
                String user_name = rs.getString("name");
                String user_address = rs.getString("user_address");
                Timestamp user_birth = rs.getTimestamp("user_birth");
                String user_email = rs.getString("user_email");
                Boolean user_gender = rs.getBoolean("user_gender");
                String user_phone = rs.getString("user_phone");
                String residence_tel = rs.getString("residence_tel");
                String blood = rs.getString("blood");
                Float height = rs.getFloat("height");
                Float weight = rs.getFloat("wieght");
                String allergy_history = rs.getString("allergy_history");
                String serverill_history = rs.getString("serverill_history");
                String contact_name = rs.getString("contact_name");
                String contact_rel = rs.getString("contact_rel");
                String contact_tel = rs.getString("contact_tel");

                /** 將每一筆使用者資料產生一名新User物件 */
                u = new User(user_id, case_number, user_name, user_address, user_birth, user_email, user_gender,
                        user_phone,
                        residence_tel, blood, height, weight, allergy_history, serverill_history, contact_name,
                        contact_rel, contact_tel);
                /** 取出該使用者之資料並封裝至 JSONsonArray 內 */
                jsa.put(u.getData());
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
     * 透過身分證字號（ID）取得使用者資料
     * 
     * @return the JSON object 回傳SQL執行結果與該身分證字號之使用者資料
     */
    public JSONObject getByID(String id) {
        JSONObject data = new JSONObject();
        User u = null;
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
            String sql = "SELECT * FROM `hosptial`.`user` WHERE `user`.`user_id` = ? LIMIT 1";

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
                String user_id = rs.getString("user_id");
                int case_number = rs.getInt("case_number");
                String user_name = rs.getString("name");
                String user_address = rs.getString("user_address");
                Timestamp user_birth = rs.getTimestamp("user_birth");
                String user_email = rs.getString("user_email");
                Boolean user_gender = rs.getBoolean("user_gender");
                String user_phone = rs.getString("user_phone");
                String residence_tel = rs.getString("residence_tel");
                String blood = rs.getString("blood");
                Float height = rs.getFloat("height");
                Float weight = rs.getFloat("wieght");
                String allergy_history = rs.getString("allergy_history");
                String serverill_history = rs.getString("serverill_history");
                String contact_name = rs.getString("contact_name");
                String contact_rel = rs.getString("contact_rel");
                String contact_tel = rs.getString("contact_tel");

                /** 將每一筆使用者資料產生一名新User物件 */
                u = new User(user_id, case_number, user_name, user_address, user_birth, user_email, user_gender,
                        user_phone,
                        residence_tel, blood, height, weight, allergy_history, serverill_history, contact_name,
                        contact_rel, contact_tel);
                /** 取出該項使用者之資料並封裝至 JSONsonArray 內 */
                data = u.getData();
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
        response.put("data", data);

        return response;
    }

    /**
     * 檢查該名使用者之身分證字號是否為初診
     * 
     * @return boolean 若不為初診回傳True，若該身分證字號不存在則回傳False
     */
    public boolean checkDuplicate(User u) {
        /** 紀錄SQL總行數，若為「-1」代表資料庫檢索尚未完成 */
        int row = -1;
        /** 儲存JDBC檢索資料庫後回傳之結果，以 pointer 方式移動到下一筆資料 */
        ResultSet rs = null;

        try {
            /** 取得資料庫之連線 */
            conn = DBMgr.getConnection();
            /** SQL指令 */
            String sql = "SELECT count(*) FROM `hostipal`.`user` WHERE `user_id` = ?";

            /** 取得所需之參數 */
            String user_id = u.getID();

            /** 將參數回填至SQL指令當中 */
            pres = conn.prepareStatement(sql);
            pres.setString(1, user_id);
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
     * 建立該名使用者至資料庫
     * 
     * @return the JSON object 回傳SQL指令執行之結果
     */
    public JSONObject create(User u) {
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
            String sql = "INSERT INTO `hostipal`.`user`(`user_id`, `name`, `user_address`, `user_birth`, `user_email`, `user_gender`, `user_phone`, `residence_tel`, `blood`, `height`, `weight`, `allergy_history`, `serverill_history`, `contact_name`, `contact_rel`, `contact_tel`)"
                    + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            /** 取得所需之參數 */
            String user_id = u.getID();
            // int case_number = u.getCaseNumber();
            String name = u.getName();
            String user_address = u.getAddress();
            Timestamp user_birth = u.getBirth();
            String user_email = u.getEmail();
            Boolean user_gender = u.getGender();
            String user_phone = u.getPhone();
            String residence_tel = u.getResidenceTel();
            String blood = u.getBloodType();
            Float height = u.getHeight();
            Float weight = u.getWeight();
            String AllergyHistory = u.getAllergyHistory();
            String ServillHistory = u.getServerillHistory();
            String contact_name = u.getContactName();
            String contact_rel = u.getContactRel();
            String contact_tel = u.getContactTel();

            /** 將參數回填至SQL指令當中 */
            pres = conn.prepareStatement(sql);
            pres.setString(1, user_id);
            // pres.setInt(2, case_number);
            pres.setString(2, name);
            pres.setString(3, user_address);
            pres.setTimestamp(4, user_birth);
            pres.setString(5, user_email);
            pres.setBoolean(6, user_gender);
            pres.setString(7, user_phone);
            pres.setString(8, residence_tel);
            pres.setString(9, blood);
            pres.setFloat(10, height);
            pres.setFloat(11, weight);
            pres.setString(12, AllergyHistory);
            pres.setString(13, ServillHistory);
            pres.setString(14, contact_name);
            pres.setString(15, contact_rel);
            pres.setString(16, contact_tel);

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
     * 更新一名使用者之使用者資料
     * 
     * @return the JSONObject 回傳SQL指令執行結果與執行之資料
     */
    public JSONObject update(User u) {
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
            String sql = "Update `hospital`.`user` SET `name` = ? ,`user_address` = ? ,`user_birth` = ? ,`user_email` = ? ,`user_gender` = ? ,`user_phone` = ? ,`residence_tel` = ? ,`blood` = ? ,`height` = ? ,`weight` = ? ,`allergy_history` = ? ,`serverill_history` = ? ,`contact_name` = ? ,`contact_rel` = ? ,`contact_tel` = ? WHERE `user_id` = ?";
            /** 取得所需之參數 */
            String user_id = u.getID();
            // int case_number = u.getCaseNumber();
            String name = u.getName();
            String user_address = u.getAddress();
            Timestamp user_birth = u.getBirth();
            String user_email = u.getEmail();
            Boolean user_gender = u.getGender();
            String user_phone = u.getPhone();
            String residence_tel = u.getResidenceTel();
            String blood = u.getBloodType();
            Float height = u.getHeight();
            Float weight = u.getWeight();
            String AllergyHistory = u.getAllergyHistory();
            String ServillHistory = u.getServerillHistory();
            String contact_name = u.getContactName();
            String contact_rel = u.getContactRel();
            String contact_tel = u.getContactTel();

            /** 將參數回填至SQL指令當中 */
            pres = conn.prepareStatement(sql);
            // pres.setInt(1, case_number);
            pres.setString(1, name);
            pres.setString(2, user_address);
            pres.setTimestamp(3, user_birth);
            pres.setString(4, user_email);
            pres.setBoolean(5, user_gender);
            pres.setString(6, user_phone);
            pres.setString(7, residence_tel);
            pres.setString(8, blood);
            pres.setFloat(9, height);
            pres.setFloat(10, weight);
            pres.setString(11, AllergyHistory);
            pres.setString(12, ServillHistory);
            pres.setString(13, contact_name);
            pres.setString(14, contact_rel);
            pres.setString(15, contact_tel);
            pres.setString(16, user_id);
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
