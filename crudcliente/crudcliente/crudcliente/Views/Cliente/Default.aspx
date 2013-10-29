<%@ Page Title="ClienteList" Language="C#" MasterPageFile="~/Site.Master" CodeBehind="Default.aspx.cs" Inherits="renan004.ClienteActions.Default" ViewStateMode="Disabled" %>

<asp:Content runat="server" ID="Content1" ContentPlaceHolderID="HeadContent">
</asp:Content>

<asp:Content runat="server" ID="Content2" ContentPlaceHolderID="MainContent">
    <h2>Cliente List</h2>
    <p>
        <asp:HyperLink runat="server" NavigateUrl="Insert" Text="Create new" />
    </p>
    <div>
        <asp:ListView runat="server"
            DataKeyNames="cd_cliente" ItemType="renan004.Models.Cliente"
            AutoGenerateColumns="false"
            AllowPaging="true" AllowSorting="true"
            SelectMethod="GetData">
            <EmptyDataTemplate>
                There are no entries found for Cliente List
            </EmptyDataTemplate>
            <LayoutTemplate>
                <table>
                    <thead>
                        <tr>
                            <th>nm_cliente</th>
                            <th>ds_email</th>
                            <th>cd_sexo</th>
                            <th>vl_saldo_creditos</th>
                            <th>ds_logradouro</th>
                            <th>nr_logradouro</th>
                            <th>ds_complemento</th>
                            <th>nm_bairro</th>
                            <th>nm_cidade</th>
                            <th>&nbsp;</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr runat="server" id="itemPlaceholder" />
                    </tbody>
                </table>
            </LayoutTemplate>
            <ItemTemplate>
                <tr>
                    <td>
                        <asp:DynamicControl runat="server" DataField="nm_cliente" ID="nm_cliente" Mode="ReadOnly" />
                    </td>
                    <td>
                        <asp:DynamicControl runat="server" DataField="ds_email" ID="ds_email" Mode="ReadOnly" />
                    </td>
                    <td>
                        <asp:DynamicControl runat="server" DataField="cd_sexo" ID="cd_sexo" Mode="ReadOnly" />
                    </td>
                    <td>
                        <asp:DynamicControl runat="server" DataField="vl_saldo_creditos" ID="vl_saldo_creditos" Mode="ReadOnly" />
                    </td>
                    <td>
                        <asp:DynamicControl runat="server" DataField="ds_logradouro" ID="ds_logradouro" Mode="ReadOnly" />
                    </td>
                    <td>
                        <asp:DynamicControl runat="server" DataField="nr_logradouro" ID="nr_logradouro" Mode="ReadOnly" />
                    </td>
                    <td>
                        <asp:DynamicControl runat="server" DataField="ds_complemento" ID="ds_complemento" Mode="ReadOnly" />
                    </td>
                    <td>
                        <asp:DynamicControl runat="server" DataField="nm_bairro" ID="nm_bairro" Mode="ReadOnly" />
                    </td>
                    <td>
                        <asp:DynamicControl runat="server" DataField="nm_cidade" ID="nm_cidade" Mode="ReadOnly" />
                    </td>
                    <td>
                        <asp:HyperLink runat="server" NavigateUrl='<%# FriendlyUrl.Href("~/Views/Cliente/Edit", Item.cd_cliente) %>' Text="edit" />
                        <asp:HyperLink runat="server" NavigateUrl='<%# FriendlyUrl.Href("~/Views/Cliente/Delete", Item.cd_cliente) %>' Text="delete" />
                    </td>
                </tr>
            </ItemTemplate>
        </asp:ListView>
    </div>
</asp:Content>
