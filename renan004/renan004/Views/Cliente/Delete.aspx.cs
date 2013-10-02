using Microsoft.AspNet.FriendlyUrls.ModelBinding;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using renan004.Models;

namespace renan004.ClienteActions
{
    public partial class Delete : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        // This is the Delete methd to delete the selected Cliente item
        // USAGE: <asp:FormView DeleteMethod="DeleteItem">
        public void DeleteItem(int cd_cliente)
        {
            using (var context = new renan004Context())
            {
                var item = context.Cliente.Find(cd_cliente);

                if (item != null)
                {
                    context.Cliente.Remove(item);
                    context.SaveChanges();
                }
            }
            Response.Redirect("../Default");
        }

        // This is the Select methd to selects a single Cliente item with the id
        // USAGE: <asp:FormView SelectMethod="GetItem">
        public Cliente GetItem([FriendlyUrlSegmentsAttribute(0)]int? cd_cliente)
        {
            if (cd_cliente == null)
            {
                return null;
            }

            using (var context = new renan004Context())
            {
                return context.Cliente.Find(cd_cliente);
            }
        }

        protected void ItemCommand(object sender, FormViewCommandEventArgs e)
        {
            if (e.CommandName.Equals("Cancel", StringComparison.OrdinalIgnoreCase))
            {
                Response.Redirect("../Default");
            }
        }
    }
}
