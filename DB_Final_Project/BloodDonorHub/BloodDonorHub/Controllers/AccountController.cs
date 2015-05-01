using System;
using System.Globalization;
using System.Linq;
using System.Security.Claims;
using System.Threading.Tasks;
using System.Web;
using System.Web.Mvc;
using Microsoft.AspNet.Identity;
using Microsoft.AspNet.Identity.Owin;
using Microsoft.Owin.Security;
using BloodDonorHub.Models;
using BusinessLayer;

namespace BloodDonorHub.Controllers
{
    public class AccountController : Controller
    {
        //
        // GET: /Account/

        public ActionResult Index()
        {
            return View();
        }

        [HttpGet]
        [ActionName("AdminLogin")]
        public ActionResult AdminLogin()
        {
            return View();
        }

        [HttpPost]
        [ActionName("AdminLogin")]
        public ActionResult AdminLogin(RequestModel model)
        {
            return View();
        }

        [HttpGet]
        [ActionName("UserLogin")]
        public ActionResult UserLogin()
        {
            return View();
        }

        [HttpPost]
        [ActionName("UserLogin")]
        public ActionResult UserLogin(RequestModel model)
        {
            UserActions.PostRequest(model.EmployeeID, model.BloodGroupRequested, model.City);

            return View();
        }
    }
}