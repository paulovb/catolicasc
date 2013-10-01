<%@ Page Title="ClienteEdit" Language="C#" MasterPageFile="~/Site.Master" CodeBehind="Edit.aspx.cs" Inherits="CRUD_CLIENTE.ClienteActions.Edit" %>

<asp:Content runat="server" ID="Content1" ContentPlaceHolderID="HeadContent">
</asp:Content>

<asp:Content runat="server" ID="Content2" ContentPlaceHolderID="MainContent">
    <div>
        <h2>Alterar Cliente</h2>
        <asp:ValidationSummary runat="server" CssClass="validation-summary-errors" />
        <asp:FormView runat="server"
            ItemType="CRUD_CLIENTE.Models.Cliente" DefaultMode="Edit" DataKeyNames="Codigo"
            UpdateMethod="UpdateItem" SelectMethod="GetItem"
            OnItemCommand="ItemCommand" RenderOuterTable="false">
            <EmptyDataTemplate>
                Não foi possível encontrar o Cliente com o código <%= Request.GetFriendlyUrlSegments()[0] %>
            </EmptyDataTemplate>
            <EditItemTemplate>
                <fieldset>
                    <legend>Alterar Cliente</legend>
                    <ol>
                        <asp:DynamicEntity runat="server" Mode="Edit" />
                    </ol>
                    <asp:Button runat="server" ID="UpdateButton" CommandName="Update" Text="Salvar" />
                    <asp:Button runat="server" ID="CancelButton" CommandName="Cancel" Text="Cancelar" CausesValidation="false" />
                </fieldset>
            </EditItemTemplate>
        </asp:FormView>
    </div>
</asp:Content>
