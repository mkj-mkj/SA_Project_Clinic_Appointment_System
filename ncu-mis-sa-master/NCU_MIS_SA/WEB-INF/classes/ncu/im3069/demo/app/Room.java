package ncu.im3069.demo.app;

import org.json.*;

import java.security.Timestamp;
import java.util.Calendar;

// TODO: Auto-generated Javadoc
/**
 * The Class Room
 * Room類別（class）具有診室所需要之屬性與方法，並且儲存與診室相關之商業判斷邏輯
 */

public class Room {

    private int Id;

    private String Num;

    private int ClincId;

    private Clinic clinic;

    /** ch，ClinicHelper之物件與Clinic相關之資料庫方法（Sigleton） */
    private ClinicHelper ch = ClinicHelper.getHelper();

    /** rh，RoomHelper之物件與Room相關之資料庫方法（Sigleton） */
    private RoomHelper rh = RoomHelper.getHelper();

    /**
     * 實例化（Instantiates）一個新的（new）Room物件
     */
    public Room(int Id) {

    }

    /**
     * 實例化（Instantiates）一個新的（new）Room物件
     */
    public Room(int Id, String Num) {

    }

    /**
     * 實例化（Instantiates）一個新的（new）Room物件
     */
    public Room(int Id, String Num, String ClincId) {

    }

    /**
     * 取得診室編號
     *
     * @return the id 回傳診室編號
     */
    public int getID() {
        return this.Id;
    }

    public String getNum() {

    }

    public int getClinicID() {

    }

    /**
     * 取得該診室所有資料
     * 
     * @return the data 取得該診室所有資料並封裝於JSONObject物件內
     */
    public JSONObject getData() {

    }

}
