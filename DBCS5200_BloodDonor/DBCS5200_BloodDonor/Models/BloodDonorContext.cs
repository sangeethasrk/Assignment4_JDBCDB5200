using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Data.Entity.ModelConfiguration.Conventions;
using System.Linq;
using System.Web;

namespace DBCS5200_BloodDonor.Models
{
    public class BloodDonorContext : DbContext
    {
        // Enables CRUD Functionality
        public DbSet<Users> Users { get; set; }
        public DbSet<BloodRequirementRequest> Requests { get; set; }
    }
}