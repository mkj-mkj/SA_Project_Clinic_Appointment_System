package ncu.im3069.demo.app;

import org.json.*;

import java.security.Timestamp;
import java.util.Calendar;

/**
 * The Class Room
 * Room類別（class）具有診室所需要之屬性與方法，並且儲存與診室相關之商業判斷邏輯
 */

public class Room {

    private int Id;

    private String Num;

    private int ClinicId;

    private Clinic clinic;

    /** ch，ClinicHelper之物件與Clinic相關之資料庫方法（Sigleton） */
    private ClinicHelper ch = ClinicHelper.getHelper();

    /** rh，RoomHelper之物件與Room相關之資料庫方法（Sigleton） */
    private RoomHelper rh = RoomHelper.getHelper();

    /**
     * 實例化（Instantiates）一個新的（new）Room物件
     */
    public Room(int Id) {
        this.Id = Id;
    }

    /**
     * 實例化（Instantiates）一個新的（new）Room物件
     */
    public Room(int Id, String Num) {
        this.Id = Id;
        this.Num = Num;
    }

    /**
     * 實例化（Instantiates）一個新的（new）Room物件
     */
    public Room(int Id, String Num, int ClinicId) {
        this.Id = Id;
        this.Num = Num;
        this.ClinicId = ClinicId;
    }

    /**
     * 取得診室編號
     * 
     * @return the id 回傳診室編號
     */
    public int getID() {
        return this.Id;
    }

    /**
     * 取得診室代號
     * 
     * @return the id 回傳診室代號
     */
    public String getNum() {
        return this.Num;
    }

    /**
     * 取得診室所屬的門診編號
     * 
     * @return the id 回傳門診編號
     */
    public int getClinicID() {
        return this.ClinicId;
    }

    /**
     * 取得該診室所有資料
     * 
     * @return the data 取得該診室所有資料並封裝於JSONObject物件內
     */
    public JSONObject getData() {
        /** 透過JSONObject將該診室所需之資料全部進行封裝 */
        JSONObject jso = new JSONObject();
        jso.put("id", getID());
        jso.put("num", getNum());
        jso.put("clinic_id", getClinicID());
        return jso;
    }

}
