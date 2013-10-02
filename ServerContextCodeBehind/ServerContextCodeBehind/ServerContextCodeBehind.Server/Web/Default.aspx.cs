using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.IO;
using System.Text;

namespace LightSwitchApplication.Web
{
    public partial class Default : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!Page.IsPostBack)
            {
                RefreshGrid();
            }
        }

        private void RefreshGrid()
        {
            // Get all PhoneCalls
            using (var serverContext = GetServerContext())
            {
                var result = from PhoneCalls in serverContext.DataWorkspace.ApplicationData
                                 .PhoneCalls.GetQuery().Execute()
                             select PhoneCalls;

                dlPhoneCalls.DataSource = result;
                dlPhoneCalls.DataBind();
            }
        }

        protected void ddlCallType_DataBound(object sender, EventArgs e)
        {
            // Get an instance of the DropDownList
            DropDownList objDropDownList = (DropDownList)sender;
            // Get the selected value from the hidden Label
            Label objLabel = (Label)objDropDownList.Parent.FindControl("lblCallType");
            // Set the selected value in the DropDownList
            objDropDownList.SelectedValue = objLabel.Text;
        }

        protected void btnSubmit_Click(object sender, EventArgs e)
        {
            using (var serverContext = GetServerContext())
            {
                try
                {
                    // Create a new PhoneCall
                    var objPhoneCall = serverContext.DataWorkspace.ApplicationData.PhoneCalls.AddNew();

                    // Set values
                    objPhoneCall.CallType = ddlCallType.SelectedValue;
                    objPhoneCall.Description = txtDescription.Text;
                    objPhoneCall.PersonCalling = txtPersonCalling.Text;
                    objPhoneCall.PhoneNumber = txtPhoneNumber.Text;
                    objPhoneCall.MessageTakenBy = 
                        (this.User.Identity.Name != "") ? this.User.Identity.Name : "[unknown]";

                    // Save changes
                    serverContext.DataWorkspace.ApplicationData.SaveChanges();

                    // Refresh the Grid
                    RefreshGrid();
                }
                catch (Exception ex)
                {
                    ShowError(ex);
                    return;
                }
            }
        }

        protected void btnUpdate_Click(object sender, EventArgs e)
        {
            // Get an instance of the Button
            Button UpdateButton = (Button)sender;
            // Get the ID of the current record from the CommandArgument
            int intID = Convert.ToInt32(UpdateButton.CommandArgument);

            using (var serverContext = GetServerContext())
            {
                try
                {
                    // Get the record
                    var result = (from PhoneCalls in serverContext.DataWorkspace.ApplicationData
                                 .PhoneCalls.GetQuery().Execute()
                                  where PhoneCalls.Id == intID
                                  select PhoneCalls).FirstOrDefault();

                    if (result != null)
                    {
                        // Get the values
                        TextBox Description =
                            (TextBox)UpdateButton.Parent.FindControl("Description");
                        TextBox PersonCalling =
                            (TextBox)UpdateButton.Parent.FindControl("PersonCalling");
                        TextBox PhoneNumber =
                            (TextBox)UpdateButton.Parent.FindControl("PhoneNumber");
                        DropDownList ddlGridCallType =
                            (DropDownList)UpdateButton.Parent.FindControl("ddlGridCallType");
                        
                        // Update the record
                        result.Description = Description.Text;
                        result.PersonCalling = PersonCalling.Text;
                        result.PhoneNumber = PhoneNumber.Text;
                        result.CallType = ddlGridCallType.SelectedValue;

                        // Save changes
                        serverContext.DataWorkspace.ApplicationData.SaveChanges();

                        // Refresh the Grid
                        RefreshGrid();
                    }
                }
                catch (Exception ex)
                {
                    ShowError(ex);
                    return;
                }
            }
        }

        protected void btnDelete_Click(object sender, EventArgs e)
        {
            // Get an instance of the Button
            Button DeleteButton = (Button)sender;
            // Get the ID of the current record from the CommandArgument
            int intID = Convert.ToInt32(DeleteButton.CommandArgument);

            using (var serverContext = GetServerContext())
            {
                try
                {
                    // Get the record
                    var result = (from PhoneCalls in serverContext.DataWorkspace.ApplicationData
                                 .PhoneCalls.GetQuery().Execute()
                                  where PhoneCalls.Id == intID
                                  select PhoneCalls).FirstOrDefault();

                    if (result != null)
                    {
                        // Delete the record
                        result.Delete();

                        // Save changes
                        serverContext.DataWorkspace.ApplicationData.SaveChanges();

                        // Refresh the Grid
                        RefreshGrid();
                    }
                }
                catch (Exception ex)
                {
                    ShowError(ex);
                    return;
                }
            }
        }

        // Utility

        #region GetServerContext
        private static ServerApplicationContext GetServerContext()
        {
            ServerApplicationContext serverContext = (LightSwitchApplication.ServerApplicationContext)ServerApplicationContext.Current;
            if (serverContext == null)
            {
                serverContext = (LightSwitchApplication.ServerApplicationContext)ServerApplicationContext.CreateContext();
            }
            return serverContext;
        } 
        #endregion

        #region ShowError(Exception ex)
        private void ShowError(Exception ex)
        {
            string strError = "";
            Microsoft.LightSwitch.ValidationException ValidationErrors = ex as Microsoft.LightSwitch.ValidationException;

            if (ValidationErrors != null)
            {
                StringBuilder sbErrorMessage = new StringBuilder();
                foreach (var error in ValidationErrors.ValidationResults)
                {
                    sbErrorMessage.Append(string.Format("<p>{0}</p>", error.Message));
                }

                strError = sbErrorMessage.ToString();
            }
            else
            {
                // This is a simple error -- just show Message
                strError = ex.Message;
            }

            // This is a simple error -- just show Message
            lblError.Text = strError;
        }
        #endregion

    }
}