using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace DBCS5200_BloodDonor.Models
{
    public class Users
    {
        public int UsersId { get; set; }
        public string Name { get; set; }
        public int Age { get; set; }
        public string Email { get; set; }
        public string BloodGroup { get; set; }
        public string Phone { get; set; }
        public string Address { get; set; }
        public Int16 Type { get; set; }
        public ICollection<DriveDonorLookUp> DriveDonorLookUp { get; set; }
        public ICollection<DonationHistory> DonationHistory { get; set; }
        public ICollection<Notifier> Notifier { get; set; }
        public ICollection<AppointmentScheduler> AppointmentScheduler { get; set; }
    }
}