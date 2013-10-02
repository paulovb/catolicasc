using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using renan004.Models;

namespace renan004.ClienteActions
{
    public partial class Default : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        // Model binding method to get List of Cliente entries
        // USAGE: <asp:ListView SelectMethod="GetData">
        public IQueryable<Cliente> GetData()
        {
            var context = new renan004Context();

            return context.Cliente;
        }
    }
}
