using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace BloodDonorHub.Models
{
    public class RequestModel
    {
        public string EmployeeID { get; set; }
        public string BloodGroupRequested { get; set; }
        public string City { get; set; }
    }
}