<%@ Page Title="ClienteEdit" Language="C#" MasterPageFile="~/Site.Master" CodeBehind="Edit.aspx.cs" Inherits="renan004.ClienteActions.Edit" %>

<asp:Content runat="server" ID="Content1" ContentPlaceHolderID="HeadContent">
</asp:Content>

<asp:Content runat="server" ID="Content2" ContentPlaceHolderID="MainContent">
    <div>
        <h2>Edit Cliente</h2>
        <asp:ValidationSummary runat="server" CssClass="validation-summary-errors" />
        <asp:FormView runat="server"
            ItemType="renan004.Models.Cliente" DefaultMode="Edit" DataKeyNames="cd_cliente"
            UpdateMethod="UpdateItem" SelectMethod="GetItem"
            OnItemCommand="ItemCommand" RenderOuterTable="false">
            <EmptyDataTemplate>
                Cannot find the Cliente with cd_cliente <%= Request.GetFriendlyUrlSegments()[0] %>
            </EmptyDataTemplate>
            <EditItemTemplate>
                <fieldset>
                    <legend>Edit Cliente</legend>
                    <ol>
                        <asp:DynamicEntity runat="server" Mode="Edit" />
                    </ol>
                    <asp:Button runat="server" ID="UpdateButton" CommandName="Update" Text="Update" />
                    <asp:Button runat="server" ID="CancelButton" CommandName="Cancel" Text="Cancel" CausesValidation="false" />
                </fieldset>
            </EditItemTemplate>
        </asp:FormView>
    </div>
</asp:Content>
