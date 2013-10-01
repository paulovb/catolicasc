<%@ Page Title="ClienteDelete" Language="C#" MasterPageFile="~/Site.Master" CodeBehind="Delete.aspx.cs" Inherits="CRUD_CLIENTE.ClienteActions.Delete" %>

<asp:Content runat="server" ID="Content1" ContentPlaceHolderID="HeadContent">
</asp:Content>

<asp:Content runat="server" ID="Content2" ContentPlaceHolderID="MainContent">
    <div>
        <h2>Excluir Cliente</h2>
        <h3>Você tem certeza que quer excluir este Cliente?</h3>
        <asp:ValidationSummary runat="server" CssClass="validation-summary-errors" />
        <asp:FormView runat="server"
            ItemType="CRUD_CLIENTE.Models.Cliente" DataKeyNames="Codigo"
            DeleteMethod="DeleteItem" SelectMethod="GetItem"
            OnItemCommand="ItemCommand" RenderOuterTable="false">
            <EmptyDataTemplate>
                Não foi possível encontrar o Cliente com o código <%= Request.GetFriendlyUrlSegments()[0] %>
            </EmptyDataTemplate>
            <ItemTemplate>
                <fieldset>
                    <legend>Excluir Cliente</legend>
                    <ol>
                        <asp:DynamicEntity runat="server" Mode="ReadOnly" />
                    </ol>
                    <asp:Button ID="DeleteButton" runat="server" CommandName="Delete" Text="Excluir" />
                    <asp:Button ID="CancelButton" runat="server" CommandName="Cancel" Text="Cancelar" />
                </fieldset>
            </ItemTemplate>
        </asp:FormView>
    </div>
</asp:Content>
