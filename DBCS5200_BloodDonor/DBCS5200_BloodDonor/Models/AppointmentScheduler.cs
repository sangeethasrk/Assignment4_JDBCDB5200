using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace DBCS5200_BloodDonor.Models
{
    public class AppointmentScheduler
    {
        public int AppointmentSchedulerId { get; set; }
        public int UsersId { get; set; }
        public int BloodDriveId { get; set; }
        public Users Users { get; set; }
    }
}