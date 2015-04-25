using System.Web;
using System.Web.Mvc;

namespace DBCS5200_BloodDonor
{
    public class FilterConfig
    {
        public static void RegisterGlobalFilters(GlobalFilterCollection filters)
        {
            filters.Add(new HandleErrorAttribute());
        }
    }
}
