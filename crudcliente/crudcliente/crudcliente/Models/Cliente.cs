using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace renan004.Models
{
    using System.ComponentModel.DataAnnotations;
    public class Cliente
    {
        [Key]
        [ScaffoldColumn(false)]
        public int cd_cliente { get; set; }
        [Required(ErrorMessage="Informe o nome")]
        [StringLength(100)]
        public string nm_cliente { get; set; }
        [Required(ErrorMessage = "Informe o e-mail")]
        [RegularExpression("^[a-z0-9_\\+-]+(\\.[a-z0-9_\\+-]+)*@[a-z0-9-]+(\\.[a-z]{2,4})$", ErrorMessage = "e-mail invalido")]        
        [StringLength(60, MinimumLength = 3)]
        public string ds_email { get; set; }
        [Required(ErrorMessage = "Informe o sexo")]
        [StringLength(1, MinimumLength = 1)]
        [RegularExpression("(m|f|M|F)", ErrorMessage = "Sexo deve ser F ou M")]
        public string cd_sexo { get; set; }
        [Required(ErrorMessage = "Informe o saldo")]
        [Range(1, 100)]
        public int vl_saldo_creditos { get; set; }
        
        [StringLength(200)]
        public string ds_logradouro { get; set; }
        public int nr_logradouro { get; set; }
        [StringLength(100)]
        public string ds_complemento { get; set; }
        
        [StringLength(50)]
        public string nm_bairro { get; set; }
        
        [StringLength(30)]
        public string nm_cidade { get; set; }
    }
}