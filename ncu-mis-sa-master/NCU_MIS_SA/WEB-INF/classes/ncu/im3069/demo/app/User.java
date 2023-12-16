package ncu.im3069.demo.app;

import org.json.*;

import java.security.Timestamp;
import java.util.Calendar;

// TODO: Auto-generated Javadoc
/**
 * <p>
 * The Class Member
 * Member類別（class）具有會員所需要之屬性與方法，並且儲存與會員相關之商業判斷邏輯<br>
 * </p>
 * 
 * @author IPLab
 * @version 1.0.0
 * @since 1.0.0
 */

public class User {

    private String Id;

    private String Name;

    private int CaseNumber;

    private String Address;

    private Timestamp Birth;

    private Boolean Gender;

    private String Email;

    private String Phone;

    private String ResidenceTel;

    private String BloodType;

    private float Height;

    private float Weight;

    private String AllergyHistory;

    private String ServillHistory;

    private String ContactName;

    private String ContactRel;

    private String ContactTel;

    /** uh，UserHelper之物件與User相關之資料庫方法（Sigleton） */
    private UserHelper uh = UserHelper.getHelper();

    /**
     * 實例化（Instantiates）一個新的（new）User物件<br>
     * 採用多載（overload）方法進行，此建構子用於建立會員資料時，產生一名新的會員
     */
    public User(String Id, String Name) {
        this.Id = Id;
        this.Name = Name;
    }

    /**
     * 實例化（Instantiates）一個新的（new）User物件<br>
     * 採用多載（overload）方法進行，此建構子用於建立會員資料時，產生一名新的會員
     */
    public User(String Id, String Name, int CaseNumber) {
        this.Id = Id;
        this.Name = Name;
        this.CaseNumber = CaseNumber;
    }

    /**
     * 實例化（Instantiates）一個新的（new）User物件<br>
     * 採用多載（overload）方法進行，此建構子用於建立會員資料時，產生一名新的會員
     */
    public User(String Id, String Name, int CaseNumber, String Address, Timestamp Birth, Boolean Gender, String Email,
            String Phone, String ResidenceTel, String BloodType, float Height, float Weight, String AllergyHistory,
            String ServillHistory, String ContactName, String ContactRel, String ContactTel) {
        this.Id = Id;
        this.Name = Name;
        this.CaseNumber = CaseNumber;
        this.Address = Address;
        this.Birth = Birth;
        this.Email = Email;
        this.Gender = Gender;
        this.Phone = Phone;
        this.ResidenceTel = ResidenceTel;
        this.BloodType = BloodType;
        this.Height = Height;
        this.Weight = Weight;
        this.AllergyHistory = AllergyHistory;
        this.ServillHistory = ServillHistory;
        this.ContactName = ContactName;
        this.ContactRel = ContactRel;
        this.ContactTel = ContactTel;
    }

    /**
     * 取得使用者之身分證字號
     *
     * @return the id 回傳會員編號
     */
    public String getID() {
        return this.Id;
    }

    public int getCaseNumber() {
        return this.CaseNumber;
    }

    public String getName() {

    }

    public String getAddress() {

    }

    public Timestamp getBirth() {

    }

    public Boolean getGender() {

    }

    public String getEmail() {

    }

    public String getPhone() {

    }

    public String getResidenceTel() {

    }

    public String getBloodType() {

    }

    public Float getHeight() {

    }

    public Float getWeight() {

    }

    public String getAllergyHistory() {

    }

    public String getServerillHistory() {

    }

    public String getContactName() {

    }

    public String getContactRel() {

    }

    public String getContactTel() {

    }

    /**
     * 更新使用者資料
     *
     * @return the JSON object 回傳SQL更新之結果與相關封裝之資料
     */
    public JSONObject update() {

    }

    /**
     * 取得該名使用者所有資料
     *
     * @return the data 取得該名使用噁之所有資料並封裝於JSONObject物件內
     */
    public JSONObject getData() {

    }

    /**
     * 計算使用者之病例編號<br>
     */
    private void setCaseNumber() {

    }
}