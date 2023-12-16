package ncu.im3069.demo.app;

import java.sql.*;
import java.time.LocalDateTime;
import org.json.*;

import ncu.im3069.demo.util.DBMgr;

// TODO: Auto-generated Javadoc
/**
 * <p>
 * The Class AnnouncementHelper<br>
 * AnnouncementHelper類別（class）主要管理所有與Announcement相關與資料庫之方法（method）
 * </p>
 * 
 * @author IPLab
 * @version 1.0.0
 * @since 1.0.0
 */

public class AnnouncementHelper {

    /**
     * 實例化（Instantiates）一個新的（new）AnnouncementHelper物件<br>
     * 採用Singleton不需要透過new
     */
    private AnnouncementHelper() {

    }

    /** 靜態變數，儲存AnnouncementHelper物件 */
    private static AnnouncementHelper anh;

    /** 儲存JDBC資料庫連線 */
    private Connection conn = null;

    /** 儲存JDBC預準備之SQL指令 */
    private PreparedStatement pres = null;

    /**
     * 靜態方法<br>
     * 實作Singleton（單例模式），僅允許建立一個AnnouncementHelper物件
     * 
     * @return the helper 回傳AnnouncementHelper物件
     */
    public static AnnouncementHelper getHelper() {
        /** Singleton檢查是否已經有AnnouncementHelper物件，若無則new一個，若有則直接回傳 */
        if (anh == null)
            anh = new AnnouncementHelper();

        return anh;
    }

    /**
     * 透過公告流水號（Seq）刪除公告
     * 
     * @return the JSONObject 回傳SQL執行結果
     */
    public JSONObject deleteBySeq(int Seq) {

    }

    /**
     * 取回所有公告資料
     * 
     * @return the JSONObject 回傳SQL執行結果與自資料庫取回之所有資料
     */
    public JSONObject getAll() {

    }

    /**
     * 透過公告流水號（Seq）取得公告資料
     * 
     * @return the JSON object 回傳SQL執行結果與該公告流水號之公告資料
     */
    public JSONObject getByID(int Seq) {

    }

    /**
     * 檢查該公告是否重複輸入
     * 
     * @return boolean 若已存在回傳False，若不存在則回傳True
     */
    public boolean checkDuplicate(Announcement an) {

    }

    /**
     * 建立公告至資料庫
     * 
     * @return the JSON object 回傳SQL指令執行之結果
     */
    public JSONObject create(Announcement an) {

    }

    /**
     * 更新公告資料
     * 
     * @return the JSONObject 回傳SQL指令執行結果與執行之資料
     */
    public JSONObject update(Announcement an) {

    }

}
