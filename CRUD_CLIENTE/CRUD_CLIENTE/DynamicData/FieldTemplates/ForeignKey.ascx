<%@ Control Language="C#" CodeBehind="ForeignKey.ascx.cs" Inherits="CRUD_CLIENTE.ForeignKeyField" %>

<asp:HyperLink ID="HyperLink1" runat="server"
    Text="<%# GetDisplayString() %>"
    NavigateUrl="<%# GetNavigateUrl() %>"  />

