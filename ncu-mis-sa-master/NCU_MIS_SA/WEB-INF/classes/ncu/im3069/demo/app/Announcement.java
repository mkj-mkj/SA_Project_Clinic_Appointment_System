package ncu.im3069.demo.app;

import org.json.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Calendar;

/**
 * The Class Announcement
 * Announcement類別（class）具有公告所需要之屬性與方法，並且儲存與公告相關之商業判斷邏輯
 */

public class Announcement {

    private int Seq;

    private String Title;

    private String Content;

    private String UpdateTime;

    /** anh，AnnouncementHelper之物件與Announcement相關之資料庫方法（Sigleton） */
    private AnnouncementHelper anh = AnnouncementHelper.getHelper();

    /**
     * 實例化（Instantiates）一個新的（new）Announcement物件
     */
    public Announcement(int Seq) {
        this.Seq = Seq;
    }

    /**
     * 實例化（Instantiates）一個新的（new）Announcement物件
     */
    public Announcement(int Seq, String Title, String Content) {
        this.Seq = Seq;
        this.Title = Title;
        this.Content = Content;
    }

    /**
     * 實例化（Instantiates）一個新的（new）Announcement物件
     */
    public Announcement(String Title, String Content) {
        this.Title = Title;
        this.Content = Content;
    }

    /**
     * 實例化（Instantiates）一個新的（new）Announcement物件
     */
    public Announcement(String Title, String Content, String UpdateTime) {
        this.Title = Title;
        this.Content = Content;
        this.UpdateTime = UpdateTime;
    }

    /**
     * 實例化（Instantiates）一個新的（new）Announcement物件
     */
    public Announcement(int Seq, String Title, String Content, String UpdateTime) {
        this.Seq = Seq;
        this.Title = Title;
        this.Content = Content;
        this.UpdateTime = UpdateTime;
    }

    /**
     * 取得公告流水號
     * 
     * @return the id 回傳公告流水號
     */
    public int getSeq() {
        return this.Seq;
    }

    /**
     * 取得公告標題
     * 
     * @return the id 回傳公告標題
     */
    public String getTitle() {
        return this.Title;
    }

    /**
     * 取得公告內容
     * 
     * @return the id 回傳公告內容
     */
    public String getContent() {
        return this.Content;
    }

    /**
     * 取得公告更新時間
     * 
     * @return the id 回傳公告更新時間
     */
    public String getUpdateTime() {
        return this.UpdateTime;
    }

    public String setUpdateTime() {
        /** 設定更新資料時間 */
        Calendar calendar = Calendar.getInstance();
        int Day_of_Month = calendar.get(Calendar.DAY_OF_MONTH);
        int Month_of_Year = calendar.get(Calendar.MONTH);
        int Year = calendar.get(Calendar.YEAR);
        int Hour = calendar.get(Calendar.HOUR_OF_DAY);
        int Minute = calendar.get(Calendar.MINUTE);
        int Second = calendar.get(Calendar.SECOND);
        this.UpdateTime = Integer.toString(Year) + "-" + Integer.toString(Month_of_Year) + "-"
                + Integer.toString(Day_of_Month) + " " + Integer.toString(Hour) + ":" + Integer.toString(Minute) + ":"
                + Integer.toString(Second);
    }

    /**
     * 更新公告資料
     * 
     * @return the JSON object 回傳SQL更新之結果與相關封裝之資料
     */
    public JSONObject update() {
        /** 新建一個JSONObject用以儲存更新後之資料 */
        JSONObject data = new JSONObject();
        /** 取得更新資料日期 */
        Calendar calendar = Calendar.getInstance();
        int Day_of_Month = calendar.get(Calendar.DAY_OF_MONTH);
        int Month_of_Year = calendar.get(Calendar.MONTH);
        int Year = calendar.get(Calendar.YEAR);
        int Hour = calendar.get(Calendar.HOUR_OF_DAY);
        int Minute = calendar.get(Calendar.MINUTE);
        int Second = calendar.get(Calendar.SECOND);
        this.UpdateTime = Integer.toString(Year) + "-" + Integer.toString(Month_of_Year) + "-"
                + Integer.toString(Day_of_Month) + " " + Integer.toString(Hour) + ":" + Integer.toString(Minute) + ":"
                + Integer.toString(Second);

        /** 檢查該公告是否已經在資料庫 */
        if (this.Seq != 0) {
            data = anh.update(this);
        }

        return data;
    }

    /**
     * 取得該公告所有資料
     * 
     * @return the data 取得該公告之所有資料並封裝於JSONObject物件內
     */
    public JSONObject getData() {
        /** 透過JSONObject將該公告資料所需之資料全部進行封裝 */
        JSONObject jso = new JSONObject();
        jso.put("announce_seq", getSeq());
        jso.put("announce_title", getTitle());
        jso.put("announce_content", getContent());
        jso.put("announce_update", getUpdateTime());

        return jso;
    }

    /**
     * 改到資料庫實作
     * /**
     * 計算新公告流水號
     * 
     * private void setSeq() {
     * 
     * }
     */

}
