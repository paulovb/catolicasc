<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Default.aspx.cs" Inherits="LightSwitchApplication.Web.Default" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1" runat="server">
    <title>Phone Calls</title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <style type="text/css">
                .style1
                {
                    font-weight: normal;
                }
            </style>
            <asp:DataList ID="dlPhoneCalls" runat="server" GridLines="Both">
                <HeaderTemplate>
                    &nbsp;</td><td>
                        <strong>Description</strong> </td>
                    <td>
                        <strong>Person Calling</strong>
                    </td>
                    <td>
                        <strong>Phone Number</strong>
                    </td>
                    <td>
                        <strong>Call Type</strong>
                </HeaderTemplate>
                <ItemTemplate>
                    <asp:Button ID="btnDelete" runat="server" Text="Delete"
                        CommandArgument='<%# Eval("Id") %>' OnClick="btnDelete_Click" />
                    <asp:Button ID="btnUpdate" runat="server" OnClick="btnUpdate_Click"
                        Text="Update" CommandArgument='<%# Eval("Id") %>' />
                    </td><td>
                        <asp:TextBox ID="Description" runat="server" Text='<%# Eval("Description") %>' />
                    </td>
                    <td>
                        <asp:TextBox ID="PersonCalling" runat="server" Text='<%# Eval("PersonCalling") %>' />
                    </td>
                    <td>
                        <asp:TextBox ID="PhoneNumber" runat="server" Text='<%# Eval("PhoneNumber") %>' />
                    </td>
                    <td>
                        <asp:Label ID="lblCallType" runat="server" Text='<%# Eval("CallType") %>' Visible="False" />
                        <asp:DropDownList ID="ddlGridCallType" runat="server"
                            OnDataBound="ddlCallType_DataBound">
                            <asp:ListItem>Sales</asp:ListItem>
                            <asp:ListItem>Service</asp:ListItem>
                            <asp:ListItem>Other</asp:ListItem>
                        </asp:DropDownList>
                </ItemTemplate>
            </asp:DataList>
            <p>
                &nbsp;
            </p>
            <h2 class="style1">Insert New:</h2>
            <table>
                <tr>
                    <td align="right">
                        <strong>Description</strong>
                    </td>
                    <td>
                        <asp:TextBox ID="txtDescription" runat="server"></asp:TextBox>
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <strong>Person Calling</strong>
                    </td>
                    <td>
                        <asp:TextBox ID="txtPersonCalling" runat="server"></asp:TextBox>
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <strong>Phone Number</strong>
                    </td>
                    <td>
                        <asp:TextBox ID="txtPhoneNumber" runat="server"></asp:TextBox>
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <strong>Call Type</strong>
                    </td>
                    <td>
                        <asp:DropDownList ID="ddlCallType" runat="server">
                            <asp:ListItem>Sales</asp:ListItem>
                            <asp:ListItem>Service</asp:ListItem>
                            <asp:ListItem>Other</asp:ListItem>
                        </asp:DropDownList>
                    </td>
                </tr>
                <tr>
                    <td align="right">&nbsp;
                    </td>
                    <td align="right">
                        <asp:Button ID="btnSubmit" runat="server" OnClick="btnSubmit_Click" Text="Submit" />
                    </td>
                </tr>
            </table>
            <asp:Label ID="lblError" runat="server" EnableViewState="False" ForeColor="Red"></asp:Label>
        </div>
    </form>
</body>
</html>

