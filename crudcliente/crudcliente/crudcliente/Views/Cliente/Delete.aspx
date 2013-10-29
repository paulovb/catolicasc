<%@ Page Title="ClienteDelete" Language="C#" MasterPageFile="~/Site.Master" CodeBehind="Delete.aspx.cs" Inherits="renan004.ClienteActions.Delete" %>

<asp:Content runat="server" ID="Content1" ContentPlaceHolderID="HeadContent">
</asp:Content>

<asp:Content runat="server" ID="Content2" ContentPlaceHolderID="MainContent">
    <div>
        <h2>Delete Cliente</h2>
        <h3>Are you sure want to delete this Cliente?</h3>
        <asp:ValidationSummary runat="server" CssClass="validation-summary-errors" />
        <asp:FormView runat="server"
            ItemType="renan004.Models.Cliente" DataKeyNames="cd_cliente"
            DeleteMethod="DeleteItem" SelectMethod="GetItem"
            OnItemCommand="ItemCommand" RenderOuterTable="false">
            <EmptyDataTemplate>
                Cannot find the Cliente with cd_cliente <%= Request.GetFriendlyUrlSegments()[0] %>
            </EmptyDataTemplate>
            <ItemTemplate>
                <fieldset>
                    <legend>Delete Cliente</legend>
                    <ol>
                        <asp:DynamicEntity runat="server" Mode="ReadOnly" />
                    </ol>
                    <asp:Button ID="DeleteButton" runat="server" CommandName="Delete" Text="Delete" />
                    <asp:Button ID="CancelButton" runat="server" CommandName="Cancel" Text="Cancel" />
                </fieldset>
            </ItemTemplate>
        </asp:FormView>
    </div>
</asp:Content>
