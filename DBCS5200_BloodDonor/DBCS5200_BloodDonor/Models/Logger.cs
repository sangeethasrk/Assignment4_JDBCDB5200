using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace DBCS5200_BloodDonor.Models
{
    public class Logger
    {
        public int LoggerId { get; set; }
        public int UsersId { get; set; }
        public string UserName { get; set; }
        public string Password { get; set; }
    }
}