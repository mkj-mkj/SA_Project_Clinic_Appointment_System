package ncu.im3069.demo.app;

import org.json.*;

import netscape.javascript.JSObject;

import java.security.Timestamp;
import java.util.Calendar;

// TODO: Auto-generated Javadoc
/**
 * The Class Member
 * Administrator類別（class）具有管理者所需要之屬性與方法，並且儲存與管理者相關之商業判斷邏輯
 */

public class Administrator {

    private int Id;

    private String Name;

    private String Email;

    private String Password;
    

    /** ah，UserHelper之物件與User相關之資料庫方法（Sigleton） */
    private AdministratorHelper ah = AdministratorHelper.getHelper();

    /**
     * 實例化（Instantiates）一個新的（new）Administrator物件
     * 採用多載（overload）方法進行，此建構子用於建立管理者資料時，產生一名新的管理者
     */
    public Administrator() {

    }

    /**
     * 實例化（Instantiates）一個新的（new）Administrator物件
     * 採用多載（overload）方法進行，此建構子用於建立管理者資料時，產生一名新的管理者
     */
    public Administrator(String Name, String Email) {
        this.Name = Name;
        this.Email = Email;
    }

    /**
     * 實例化（Instantiates）一個新的（new）Administrator物件
     * 採用多載（overload）方法進行，此建構子用於建立管理者資料時，產生一名新的管理者
     */
    public Administrator(String Name, String Email, String Password) {
        this.Name = Name;
        this.Email = Email;
        this.Password = Password;
    }

    public Administrator(int Id,String Name, String Email, String Password) {
        this.Name = Name;
        this.Email = Email;
        this.Password = Password;
        this.Id = Id;
    }

    /**
     * 取得管理者之電子信箱
     *
     * @return the id 回傳管理者編號
     */
    public int getID() {
        return this.Id;
    }

    public String getName() {
        return this.Name;
    }

    public String getEmail() {
        return this.Email;
    }

    public String Password() {
        return this.Password;
    }

    /**
     * 更新管理者資料
     * 
     * @return the JSON object 回傳SQL更新之結果與相關封裝之資料
     */
    public JSONObject update() {
        JSONObject data = new JSONObject();

        /** 檢查該名管理員是否已經在資料庫 */
        if(this.Id != 0) {
            /** 透過MemberHelper物件，更新目前之會員資料置資料庫中 */
            data = ah.update(this);
        }
        return data;
    }

    /**
     * 取得該名管理者所有資料
     * 
     * @return the data 取得該名管理者之所有資料並封裝於JSONObject物件內
     */
    public JSONObject getData() {
        /** 透過JSONObject將該管理者所需之資料全部進行封裝 */
        JSONObject jso = new JSONObject();
        jso.put("id", getID());
        jso.put("name", getName());
        jso.put("email", getEmail());
        jso.put("password", Password());
        return jso;
    }

    /**
     * 計算新管理者編號<br>
     */
    // private void setID() {

    // }
}
