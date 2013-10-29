<%@ Page Title="ClienteInsert" Language="C#" MasterPageFile="~/Site.Master" CodeBehind="Insert.aspx.cs" Inherits="renan004.ClienteActions.Insert" %>

<asp:Content runat="server" ID="Content1" ContentPlaceHolderID="HeadContent">
</asp:Content>

<asp:Content runat="server" ID="Content2" ContentPlaceHolderID="MainContent">
    <div>
        <h2>Insert Cliente</h2>
        <asp:ValidationSummary runat="server" CssClass="validation-summary-errors" />
        <asp:FormView runat="server"
            ItemType="renan004.Models.Cliente" DefaultMode="Insert"
            InsertItemPosition="FirstItem" InsertMethod="InsertItem"
            OnItemCommand="ItemCommand" RenderOuterTable="false">
            <InsertItemTemplate>
                <fieldset>
                    <ol>
                        <asp:DynamicEntity runat="server" Mode="Insert" />
                    </ol>
                    <asp:Button runat="server" ID="InsertButton" CommandName="Insert" Text="Insert" />
                    <asp:Button runat="server" ID="CancelButton" CommandName="Cancel" Text="Cancel" CausesValidation="false" />
                </fieldset>
            </InsertItemTemplate>
        </asp:FormView>
    </div>
</asp:Content>
