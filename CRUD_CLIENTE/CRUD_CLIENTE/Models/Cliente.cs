using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace CRUD_CLIENTE.Models
{
    public class Cliente
    {
        [Key]
        [ScaffoldColumn(false)]
        public int    CD_CLIENTE { get; set; }
        public string NM_CLIENTE { get; set; }
        public string DS_EMAIL { get; set; }
        public string CD_SEXO { get; set; }
        public double VL_SALDO_CREDITOS { get; set; }
        public string DS_LOGRADOURO { get; set; }
        public int    NR_LOGRADOURO { get; set; }
        public string DS_COMPLEMENTO { get; set; }
        public string NM_BAIRRO { get; set; }
        public string NM_CIDADE { get; set; }
    }
}