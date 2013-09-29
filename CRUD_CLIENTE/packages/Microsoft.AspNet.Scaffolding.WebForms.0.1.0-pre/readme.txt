==========================================================
ASP.NET Web Forms scaffold generator v0.1.0-pre
==========================================================

----------------------------------------------------------
Overview
----------------------------------------------------------
The ASP.NET Web Forms scaffold generator produces
Create-Read-Update-Delete desktop and/or mobile
views based on a model in a project.

For more information see http://go.microsoft.com/fwlink/?LinkID=275606&clcid=0x409

----------------------------------------------------------
Setup
----------------------------------------------------------
The generated code uses ASP.NET Friendly URLs.
For more information about ASP.NET Friendly URLs see
http://go.microsoft.com/fwlink/?LinkID=264514&clcid=0x409

If you do not have the ASP.NET and Web Tools 2012.2 update,
the following should be done for Friendly URLs to work.

If your app didn't have a RouteConfig class before
installing ASP.NET Web Forms Scaffold Generator package:
----------------------------------------------------------
  The package includes a RouteConfig class that contains
  the call required to enable Friendly URLs. This call must
  be made from the Application_Start handler in your app's
  Global.asax file.

  Add the following to your Global.asax.cs file:

    using System.Web.Routing;
    ...
    protected void Application_Start(object sender, EventArgs e)
    {
        RouteConfig.RegisterRoutes(RouteTable.Routes);
    }


If your app had a RouteConfig class before installing
ASP.NET Web Forms Scaffold Generator package:
----------------------------------------------------------
  You'll need to update your RouteConfig class to enable
  Friendly URLs.

  Call EnableFriendlyUrls() in your RegisterRoutes method:

    public static void RegisterRoutes(RouteCollection routes)
    {
        routes.EnableFriendlyUrls();
    }

Also the generated mobile views reference 1.2.0 version of
stylesheets from jquery.mobile package. If you are using a later
version of the package, the references should be updated.
