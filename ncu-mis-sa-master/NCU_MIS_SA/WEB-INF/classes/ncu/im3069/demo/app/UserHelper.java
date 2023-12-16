package ncu.im3069.demo.app;

import java.sql.*;
import java.time.LocalDateTime;
import org.json.*;

import ncu.im3069.demo.util.DBMgr;

// TODO: Auto-generated Javadoc
/**
 * <p>
 * The Class UserHelper<br>
 * UserHelper類別（class）主要管理所有與Member相關與資料庫之方法（method）
 * </p>
 * 
 * @author IPLab
 * @version 1.0.0
 * @since 1.0.0
 */

public class UserHelper {

    /**
     * 實例化（Instantiates）一個新的（new）UserHelper物件
     * 採用Singleton不需要透過new
     */
    private UserHelper() {

    }

    /** 靜態變數，儲存MemberHelper物件 */
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
    public JSONObject deleteByID(int id) {

    }

    /**
     * 取回所有使用者資料
     * 
     * @return the JSONObject 回傳SQL執行結果與自資料庫取回之所有資料
     */
    public JSONObject getAll() {

    }

    /**
     * 透過身分證字號（ID）取得使用者資料
     * 
     * @return the JSON object 回傳SQL執行結果與該身分證字號之使用者資料
     */
    public JSONObject getByID(String id) {

    }

    /**
     * 檢查該名使用者之身分證字號是否為初診
     * 
     * @return boolean 若不為初診回傳False，若該身分證字號不存在則回傳True
     */
    public boolean checkDuplicate(User u) {

    }

    /**
     * 建立該名使用者至資料庫
     * 
     * @return the JSON object 回傳SQL指令執行之結果
     */
    public JSONObject create(User u) {

    }

    /**
     * 更新一名會員之使用者資料
     * 
     * @return the JSONObject 回傳SQL指令執行結果與執行之資料
     */
    public JSONObject update(User u) {

    }

}
