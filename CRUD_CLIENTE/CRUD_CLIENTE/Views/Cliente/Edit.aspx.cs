using Microsoft.AspNet.FriendlyUrls.ModelBinding;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using CRUD_CLIENTE.Models;

namespace CRUD_CLIENTE.ClienteActions
{
    public partial class Edit : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        // This is the Update methd to update the selected Cliente item
        // USAGE: <asp:FormView UpdateMethod="UpdateItem">
        public void UpdateItem(int Codigo)
        {
            using (var context = new CRUD_CLIENTEContext())
            {
                var item = context.Cliente.Find(Codigo);

                if (item == null)
                {
                    // The item wasn't found
                    ModelState.AddModelError("", String.Format("Item with id {0} was not found", Codigo));
                    return;
                }

                TryUpdateModel(item);

                if (ModelState.IsValid)
                {
                    // Save changes here
                    context.SaveChanges();
                    Response.Redirect("../Default");
                }
            }
        }

        // This is the Select methd to selects a single Cliente item with the id
        // USAGE: <asp:FormView SelectMethod="GetItem">
        public CRUD_CLIENTE.Models.Cliente GetItem([FriendlyUrlSegmentsAttribute(0)]int? Codigo)
        {
            if (Codigo == null)
            {
                return null;
            }

            using (var context = new CRUD_CLIENTEContext())
            {
                return context.Cliente.Find(Codigo);
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
