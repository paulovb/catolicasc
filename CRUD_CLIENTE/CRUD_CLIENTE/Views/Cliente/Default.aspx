<%@ Page Title="ClienteList" Language="C#" MasterPageFile="~/Site.Master" CodeBehind="Default.aspx.cs" Inherits="CRUD_CLIENTE.ClienteActions.Default" ViewStateMode="Disabled" %>

<asp:Content runat="server" ID="Content1" ContentPlaceHolderID="HeadContent">
</asp:Content>

<asp:Content runat="server" ID="Content2" ContentPlaceHolderID="MainContent">
    <h2>Lista de Clientes</h2>
    <div>
        <asp:ListView runat="server"
            DataKeyNames="Codigo" ItemType="CRUD_CLIENTE.Models.Cliente"
            AutoGenerateColumns="false"
            AllowPaging="true" AllowSorting="true"
            SelectMethod="GetData">
            <EmptyDataTemplate>
                Não há Clientes cadastrados no momento.
            </EmptyDataTemplate>
            <LayoutTemplate>
                <table>
                    <thead>
                        <tr>
                            <th>Nome</th>
                            <th>Email</th>
                            <th>Sexo</th>
                            <th>Saldo de Creditos</th>
                            <th>Descricao do Logradouro</th>
                            <th>Numero do Logradouro</th>
                            <th>Complemento</th>
                            <th>Bairro</th>
                            <th>Cidade</th>
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
                        <asp:DynamicControl runat="server" DataField="NM_CLIENTE" ID="NM_CLIENTE" Mode="ReadOnly" />
                    </td>
                    <td>
                        <asp:DynamicControl runat="server" DataField="DS_EMAIL" ID="DS_EMAIL" Mode="ReadOnly" />
                    </td>
                    <td>
                        <asp:DynamicControl runat="server" DataField="CD_SEXO" ID="CD_SEXO" Mode="ReadOnly" />
                    </td>
                    <td>
                        <asp:DynamicControl runat="server" DataField="VL_SALDO_CREDITOS" ID="VL_SALDO_CREDITOS" Mode="ReadOnly" />
                    </td>
                    <td>
                        <asp:DynamicControl runat="server" DataField="DS_LOGRADOURO" ID="DS_LOGRADOURO" Mode="ReadOnly" />
                    </td>
                    <td>
                        <asp:DynamicControl runat="server" DataField="NR_LOGRADOURO" ID="NR_LOGRADOURO" Mode="ReadOnly" />
                    </td>
                    <td>
                        <asp:DynamicControl runat="server" DataField="DS_COMPLEMENTO" ID="DS_COMPLEMENTO" Mode="ReadOnly" />
                    </td>
                    <td>
                        <asp:DynamicControl runat="server" DataField="NM_BAIRRO" ID="NM_BAIRRO" Mode="ReadOnly" />
                    </td>
                    <td>
                        <asp:DynamicControl runat="server" DataField="NM_CIDADE" ID="NM_CIDADE" Mode="ReadOnly" />
                    </td>
                    <td>
                        <asp:HyperLink runat="server" NavigateUrl='<%# FriendlyUrl.Href("~/Views/Cliente/Edit", Item.CD_CLIENTE) %>' Text="Alterar" />
                        <asp:HyperLink runat="server" NavigateUrl='<%# FriendlyUrl.Href("~/Views/Cliente/Delete", Item.CD_CLIENTE) %>' Text="Excluir" />
                    </td>
                </tr>
            </ItemTemplate>
        </asp:ListView>
    </div>
</asp:Content>
