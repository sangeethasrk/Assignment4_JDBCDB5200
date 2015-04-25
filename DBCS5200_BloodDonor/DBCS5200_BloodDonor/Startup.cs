using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(DBCS5200_BloodDonor.Startup))]
namespace DBCS5200_BloodDonor
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
