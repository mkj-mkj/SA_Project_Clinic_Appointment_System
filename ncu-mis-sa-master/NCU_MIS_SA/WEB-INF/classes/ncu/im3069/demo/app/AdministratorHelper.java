package ncu.im3069.demo.app;

import java.sql.*;
import java.time.LocalDateTime;
import org.json.*;

import ncu.im3069.demo.util.DBMgr;

// TODO: Auto-generated Javadoc
/**
 * <p>
 * The Class AdministratorHelper<br>
 * AdministratorHelper類別（class）主要管理所有與Administrator相關與資料庫之方法（method）
 * </p>
 * 
 * @author IPLab
 * @version 1.0.0
 * @since 1.0.0
 */

public class AdministratorHelper {

    /**
     * 實例化（Instantiates）一個新的（new）AdministratorHelper物件<br>
     * 採用Singleton不需要透過new
     */
    private AdministratorHelper() {

    }

    /** 靜態變數，儲存AdministratorHelper物件 */
    private static AdministratorHelper ah;

    /** 儲存JDBC資料庫連線 */
    private Connection conn = null;

    /** 儲存JDBC預準備之SQL指令 */
    private PreparedStatement pres = null;

    /**
     * 靜態方法<br>
     * 實作Singleton（單例模式），僅允許建立一個AdministratorHelper物件
     * 
     * @return the helper 回傳AdministratorHelper物件
     */
    public static AdministratorHelper getHelper() {
        /** Singleton檢查是否已經有AdministratorHelper物件，若無則new一個，若有則直接回傳 */
        if (ah == null)
            ah = new AdministratorHelper();

        return ah;
    }

    /**
     * 透過管理者編號（ID）刪除管理者
     * 
     * @return the JSONObject 回傳SQL執行結果
     */
    public JSONObject deleteByID(int id) {

    }

    /**
     * 取回所有管理者資料
     * 
     * @return the JSONObject 回傳SQL執行結果與自資料庫取回之所有資料
     */
    public JSONObject getAll() {

    }

    /**
     * 透過管理者編號（ID）取得管理者資料
     * 
     * @return the JSON object 回傳SQL執行結果與該管理者編號之管理者資料
     */
    public JSONObject getByID(String id) {

    }

    /**
     * 檢查該名管理者之電子郵件信箱是否重複註冊
     * 
     * @return boolean 若重複註冊回傳False，若該信箱不存在則回傳True
     */
    public boolean checkDuplicate(Administrator a) {

    }

    /**
     * 建立該名管理者至資料庫
     * 
     * @return the JSON object 回傳SQL指令執行之結果
     */
    public JSONObject create(Administrator a) {

    }

    /**
     * 更新一名會員之管理者資料
     * 
     * @return the JSONObject 回傳SQL指令執行結果與執行之資料
     */
    public JSONObject update(Administrator a) {

    }

}
