using System;
using System.Linq;
using System.Threading.Tasks;
using System.Web;
using System.Web.Mvc;
using Microsoft.AspNet.Identity;
using Microsoft.AspNet.Identity.Owin;
using Microsoft.Owin.Security;
using BloodDonorHub.Models;
using System.Web.Configuration;
using BusinessLayer;

namespace BloodDonorHub.Controllers
{
    public class LoginController : Controller
    {
        //
        // GET: /Login/

        public ActionResult Index()
        {
            return View();
        }

        [HttpGet]
        [ActionName("Login")]
        public ActionResult Login()
        {
            return View();
        }

        [HttpPost]
        [ActionName("Login")]
        public ActionResult Login(LoginUserModel users)
        {

            //Check if Admin Credentials,validate & redirect to admin page
            string username = WebConfigurationManager.AppSettings["AdminEmail"].ToString();
            string password = WebConfigurationManager.AppSettings["AdminPassword"].ToString();
            if (username == users.Email && password == users.Password)
            {

                TempData["Message"] = "Admin";
                return RedirectToAction("AdminLogin", "Account");
            }
            else
            {
                //If User Credentials, validate & redirect to users page
                bool isValidLogin = UserActions.ValidateLoginUser(users.Email, users.Password);

                if (isValidLogin)
                {
                    string[] name = users.Email.Split('@');
                    TempData["Message"] = name[0].ToUpper().ToString();
                    return RedirectToAction("UserLogin", "Account");
                }
            }
            ViewData["Error"] = "Login Failed, Please enter valid credentials";
            return View();

        }
    }
}