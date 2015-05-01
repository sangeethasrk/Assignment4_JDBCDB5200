using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace DBCS5200_BloodDonor.Models
{
    public class DonationHistory
    {
        public int DonationHistoryId { get; set; }
        public int UsersId { get; set; }
        public int BloodRequirementRequestId { get; set; }
        public Users Users { get; set; }
    }
}