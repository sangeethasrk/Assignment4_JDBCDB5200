using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace DBCS5200_BloodDonor.Models
{
    public class Notifier
    {
        public int NotifierId { get; set; }
        public int UsersId { get; set; }
        public int EmailId { get; set; }
        public Users Users { get; set; }
        public Email Email { get; set; }
    }
}