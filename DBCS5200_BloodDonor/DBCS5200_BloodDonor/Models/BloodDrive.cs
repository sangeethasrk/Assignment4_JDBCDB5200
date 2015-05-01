using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace DBCS5200_BloodDonor.Models
{
    public class BloodDrive
    {
        public int BloodDriveId { get; set; }
        public DateTime Date { get; set; }
        public string DriveType { get; set; }
        public string TimeSlot { get; set; }
        public bool isDriveActive { get; set; }
        public int? NoOfParticipants { get; set; }
        public ICollection<DriveDonorLookUp> DriveDonorLookUp { get; set; }
    }
}