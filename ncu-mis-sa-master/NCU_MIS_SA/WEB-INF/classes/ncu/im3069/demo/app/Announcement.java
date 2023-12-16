package ncu.im3069.demo.app;

import org.json.*;

import java.security.Timestamp;
import java.util.Calendar;

// TODO: Auto-generated Javadoc
/**
 * The Class Announcement
 * Announcement類別（class）具有公告所需要之屬性與方法，並且儲存與管理者相關之商業判斷邏輯
 */

public class Announcement {

    private int Seq;

    private String Title;

    private String Content;

    private Timestamp UpdateTime;

    /** anh，AnnouncementHelper之物件與Announcement相關之資料庫方法（Sigleton） */
    private AnnouncementHelper anh = AnnouncementHelper.getHelper();

    /**
     * 實例化（Instantiates）一個新的（new）Announcement物件
     * 採用多載（overload）方法進行，此建構子用於建立公告資料時，產生一名新的管理者
     */
    public Announcement(int Seq) {

    }

    /**
     * 實例化（Instantiates）一個新的（new）Announcement物件
     * 採用多載（overload）方法進行，此建構子用於建立公告資料時，產生一名新的管理者
     */
    public Announcement(int Seq, String Title, String Content) {

    }

    /**
     * 取得公告流水號
     *
     * @return the id 回傳公告流水號
     */
    public int getSeq() {
        return this.Seq;
    }

    public String getTitle() {

    }

    public String getTitle() {

    }

    /**
     * 更新公告資料
     * 
     * @return the JSON object 回傳SQL更新之結果與相關封裝之資料
     */
    public JSONObject update() {

    }

    /**
     * 取得該公告所有資料
     * 
     * @return the data 取得該公告之所有資料並封裝於JSONObject物件內
     */
    public JSONObject getData() {

    }

    /**
     * 計算新公告流水號
     */
    private void setSeq() {

    }
}
