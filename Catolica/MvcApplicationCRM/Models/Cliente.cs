using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace MvcApplicationCRM.Models
{
    public class Cliente
    {
        public List<string> Sexos = new List<string> { "M", "F" };

        [Key]
        [Required]
        [DatabaseGeneratedAttribute(DatabaseGeneratedOption.Identity)]
        [Column("CD_CLIENTE")]
        public long Id { get; set; }

        [Required]
        [StringLength(100)]
        [Column("NM_CLIENTE")]
        public string Nome { get; set; }

        [Required]
        [StringLength(100)]
        [DataType(DataType.EmailAddress)]
        [Column("DS_EMAIL")]
        public string Email { get; set; }

        [Required]
        [StringLength(1)]
        [RegularExpression("F|M")]
        [Column("CD_SEXO")]
        public string Sexo { get; set; }

        [Required]
        [Range(0, 100)]
        [Column("VL_SALDO_CREDITOS")]
        public decimal Saldo { get; set; }

        [StringLength(200)]
        [Column("DS_LOGRADOURO")]
        public string Rua { get; set; }

        [Column("NR_LOGRADOURO")]
        public int Numero { get; set; }

        [StringLength(100)]
        [Column("DS_COMPLEMENTO")]
        public string Complemento { get; set; }

        [StringLength(50)]
        [Column("NM_BAIRRO")]
        public string Bairro { get; set; }

        [StringLength(30)]
        [Column("NM_CIDADE")]
        public string Cidade { get; set; }

        [StringLength(2)]
        [Column("SG_ESTADO")]
        [RegularExpression("AC|AL|AP|AM|BA|CE|DF|ES|GO|MA|MT|MS|MG|PA|PB|PR|PE|PI|RJ|RN|RS|RO|RR|SC|SP|SE|TO")]
        public string Estado { get; set; }

        [StringLength(9)]
        [DataType(DataType.PostalCode)]
        //[RegularExpression(@"^\d{5}-\d{3}$")]
        [DisplayFormat(DataFormatString = "{0:#####-###}", ApplyFormatInEditMode = true)]
        [Column("NR_CEP")]
        // TODO: formatar campo
        public string CEP { get; set; }
    }
}