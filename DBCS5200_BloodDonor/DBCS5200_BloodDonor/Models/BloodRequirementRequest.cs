using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace DBCS5200_BloodDonor.Models
{
    public class BloodRequirementRequest
    {
        public int BloodRequirementRequestId { get; set; }
        public string BloodGroup { get; set; }
        public bool isPlateletsRequested { get; set; }
        public bool isDoubleRedBloodCellsRequested { get; set; }
        public bool isBloodRequested { get; set; }
        public decimal? Quantity { get; set; }
    }
}