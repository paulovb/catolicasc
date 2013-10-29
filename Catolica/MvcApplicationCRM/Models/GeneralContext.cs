using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace MvcApplicationCRM.Models
{
    public class GeneralContext : DbContext
    {
        public GeneralContext()
            : base("DefaultConnection")
        {
        }

        public DbSet<UserProfile> UserProfiles { get; set; }
        public DbSet<Cliente> Clientes { get; set; }
    }
}