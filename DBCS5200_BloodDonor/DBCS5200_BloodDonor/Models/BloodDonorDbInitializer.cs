using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace DBCS5200_BloodDonor.Models
{
    public class BloodDonorDbInitializer : DropCreateDatabaseIfModelChanges<BloodDonorContext>
    {
        protected override void Seed(BloodDonorContext context)
        {
            base.Seed(context);
        }
    }
}