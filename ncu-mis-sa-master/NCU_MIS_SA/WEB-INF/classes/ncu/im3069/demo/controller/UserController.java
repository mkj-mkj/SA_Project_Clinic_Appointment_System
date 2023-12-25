package ncu.im3069.demo.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
import org.json.*;
import java.security.Timestamp;
import ncu.im3069.demo.app.Clinic;
import ncu.im3069.demo.app.User;
import ncu.im3069.demo.app.UserHelper;
import ncu.im3069.tools.JsonReader;

// TODO: Auto-generated Javadoc
/**
 * <p>
 * The Class UserController<br>
 * UserController類別（class）主要用於處理User相關之Http請求（Request），繼承HttpServlet
 * </p>
 * 
 * @author IPLab
 * @version 1.0.0
 * @since 1.0.0
 */

public class UserController extends HttpServlet {

        /** The Constant serialVersionUID. */
        private static final long serialVersionUID = 1L;

        /** uh，UserHelper之物件與User相關之資料庫方法（Sigleton） */
        private UserHelper uh = UserHelper.getHelper();

        /**
         * 處理Http Method請求POST方法（新增資料）
         *
         * @param request  Servlet請求之HttpServletRequest之Request物件（前端到後端）
         * @param response Servlet回傳之HttpServletResponse之Response物件（後端到前端）
         * @throws ServletException the servlet exception
         * @throws IOException      Signals that an I/O exception has occurred.
         */
        public void doPost(HttpServletRequest request, HttpServletResponse response)
                        throws ServletException, IOException {
                /** 透過JsonReader類別將Request之JSON格式資料解析並取回 */
                JsonReader jsr = new JsonReader(request);
                JSONObject jso = jsr.getObject();

                /** 取出經解析到JSONObject之Request參數 */
                String user_id = jso.getString("user_id");
                String user_name = jso.getString("user_name");
                String address = jso.getString("address");
                String birth = jso.getString("birth");
                String email = jso.getString("email");
                int gender = jso.getInt("gender");
                String phone = jso.getString("phone");
                String residence_tel = jso.getString("residence_tel");
                String blood = jso.getString("blood");
                String height = jso.getString("height");
                String weight = jso.getString("weight");
                String allergy_history = jso.getString("allergy_history");
                String servill_history = jso.getString("servill_history");
                String contact_name = jso.getString("contact_name");
                String contact_rel = jso.getString("contact_rel");
                String contact_tel = jso.getString("contact_tel");

                /** 建立一個新的User物件 */
                User u = new User(user_id, user_name, address, birth, email, gender, phone, residence_tel, blood,
                                height, weight, allergy_history, servill_history, contact_name, contact_rel,
                                contact_tel);


                /** 透過UserHelper物件的checkDuplicate()檢查該使用者之身分證字號是否有重複 */
                if (!uh.checkDuplicate(u)) {
                        /** 透過UserHelper物件的create()方法新建一個使用者至資料庫 */
                        JSONObject data = uh.create(u);

                        /** 新建一個JSONObject用於將回傳之資料進行封裝 */
                        JSONObject resp = new JSONObject();
                        resp.put("status", "200");
                        resp.put("message", "成功! 註冊使用者資料...");
                        resp.put("response", data);

                        /** 透過JsonReader物件回傳到前端（以JSONObject方式） */
                        jsr.response(resp, response);
                } else {
                        /** 以字串組出JSON格式之資料 */
                        String resp = "{\"status\": \'400\', \"message\": \'新增使用者失敗，此身分證字號重複！\', \'response\': \'\'}";
                        /** 透過JsonReader物件回傳到前端（以字串方式） */
                        jsr.response(resp, response);
                }
        }

        /**
         * 處理Http Method請求GET方法（取得資料）
         *
         * @param request  Servlet請求之HttpServletRequest之Request物件（前端到後端）
         * @param response Servlet回傳之HttpServletResponse之Response物件（後端到前端）
         * @throws ServletException the servlet exception
         * @throws IOException      Signals that an I/O exception has occurred.
         */
        public void doGet(HttpServletRequest request, HttpServletResponse response)
                        throws ServletException, IOException {
                /** 透過JsonReader類別將Request之JSON格式資料解析並取回 */
                JsonReader jsr = new JsonReader(request);
                /** 若直接透過前端AJAX之data以key=value之字串方式進行傳遞參數，可以直接由此方法取回資料 */
                String id = jsr.getParameter("id");

                /** 判斷該字串是否存在，若存在代表要取回個別使用者之資料，否則代表要取回全部資料庫內使用者之資料 */
                if (id.isEmpty()) {
                        /** 透過UserHelper物件之getAll()方法取回所有使用者之資料，回傳之資料為JSONObject物件 */
                        JSONObject query = uh.getAll();

                        /** 新建一個JSONObject用於將回傳之資料進行封裝 */
                        JSONObject resp = new JSONObject();
                        resp.put("status", "200");
                        resp.put("message", "所有使用者資料取得成功");
                        resp.put("response", query);

                        /** 透過JsonReader物件回傳到前端（以JSONObject方式） */
                        jsr.response(resp, response);
                } else {
                        /** 透過UserHelper物件的getByID()方法自資料庫取回該使用者之資料，回傳之資料為JSONObject物件 */
                        JSONObject query = uh.getByID(id);

                        /** 新建一個JSONObject用於將回傳之資料進行封裝 */
                        JSONObject resp = new JSONObject();
                        resp.put("status", "200");
                        resp.put("message", "使用者資料取得成功");
                        resp.put("response", query);

                        /** 透過JsonReader物件回傳到前端（以JSONObject方式） */
                        jsr.response(resp, response);
                }
        }

        /**
         * 處理Http Method請求DELETE方法（刪除）
         *
         * @param request  Servlet請求之HttpServletRequest之Request物件（前端到後端）
         * @param response Servlet回傳之HttpServletResponse之Response物件（後端到前端）
         * @throws ServletException the servlet exception
         * @throws IOException      Signals that an I/O exception has occurred.
         */
        public void doDelete(HttpServletRequest request, HttpServletResponse response)
                        throws ServletException, IOException {
                JsonReader jsr = new JsonReader(request);
                JSONObject jso = jsr.getObject();

                /** 取出經解析到JSONObject之Request參數 */
                int case_number = jso.getInt("case_number");

                /** 透過UserHelper物件的deleteByID()方法至資料庫刪除該使用者，回傳之資料為JSONObject物件 */
                JSONObject query = uh.deleteByID(Integer.parseInt(case_number));

                /** 新建一個JSONObject用於將回傳之資料進行封裝 */
                JSONObject resp = new JSONObject();
                resp.put("status", "200");
                resp.put("message", "門診移除成功！");
                resp.put("response", query);

                /** 透過JsonReader物件回傳到前端（以JSONObject方式） */
                jsr.response(resp, response);
        }

        /**
         * 處理Http Method請求PUT方法（更新）
         *
         * @param request  Servlet請求之HttpServletRequest之Request物件（前端到後端）
         * @param response Servlet回傳之HttpServletResponse之Response物件（後端到前端）
         * @throws ServletException the servlet exception
         * @throws IOException      Signals that an I/O exception has occurred.
         */
        public void doPut(HttpServletRequest request, HttpServletResponse response)
                        throws ServletException, IOException {
                /** 透過JsonReader類別將Request之JSON格式資料解析並取回 */
                JsonReader jsr = new JsonReader(request);
                JSONObject jso = jsr.getObject();

                /** 取出經解析到JSONObject之Request參數 */
                String user_id = jso.getString("user_id");
                String user_name = jso.getString("user_name");
                String address = jso.getString("address");
                String birth = jso.getString("birth");
                String email = jso.getString("email");
                int gender = jso.getInt("gender");
                String phone = jso.getString("phone");
                String residence_tel = jso.getString("residence_tel");
                String blood = jso.getString("blood");
                String height = jso.getString("height");
                String weight = jso.getString("weight");
                String allergy_history = jso.getString("allergy_history");
                String servill_history = jso.getString("servill_history");
                String contact_name = jso.getString("contact_name");
                String contact_rel = jso.getString("contact_rel");
                String contact_tel = jso.getString("contact_tel");

                /** 透過傳入之參數，新建一個以這些參數之使用者Ussr物件 */
                User u = new User(user_id, user_name, address, birth, email, gender, phone, residence_tel, blood, null,
                                null, allergy_history, servill_history, contact_name, contact_rel, contact_tel);

                /** 透過User物件的update()方法至資料庫更新該使用者資料，回傳之資料為JSONObject物件 */
                JSONObject data = u.update();

                /** 新建一個JSONObject用於將回傳之資料進行封裝 */
                JSONObject resp = new JSONObject();
                resp.put("status", "200");
                resp.put("message", "成功! 更新使用者資料...");
                resp.put("response", data);

                /** 透過JsonReader物件回傳到前端（以JSONObject方式） */
                jsr.response(resp, response);
        }
}
