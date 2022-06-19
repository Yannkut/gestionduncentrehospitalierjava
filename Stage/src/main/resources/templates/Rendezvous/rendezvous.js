$().reday(function(){
	$("#form").validate({
		rules:{
			id:"",
			name:"required",
			prenom:"required",
			age:"required",
			num:{
				"required": true,
				minlenght:8
				
			},
			speciality:"required",
			horaire:{
				"required":"#horaire:checked",
				minlenght:1
				
			},
			message:"optional",
		},
		messages:{
			id:"gardez ce champ vide",
			name:"Entrez votre nom",
			prenom:"Entrez votre prenom",
			age:"Entrez votre age",
			num:{
				required:"Entrez votre num de Téléphone"
			}
			
		}
	})
})