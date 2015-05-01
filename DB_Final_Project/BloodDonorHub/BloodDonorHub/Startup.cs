using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(BloodDonorHub.Startup))]
namespace BloodDonorHub
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            //ConfigureAuth(app);
        }
    }
}
