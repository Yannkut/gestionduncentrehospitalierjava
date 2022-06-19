const form =document.querySelector('form')
const username =document.querySelector('username')
const password =document.querySelector('password')


form.addEventListener('submit',(event)=>{
	 event.preventDefault();
	 validateForm();
});
function validateForm(){
	//username
	if(username.value.trim()==''){
		setError(username, 'Ce champ ne doit pas être vide')
	}
	//password
}
function setError(element, errorMessage){
	const parent= element.parentElement;
	parent.classList.add('error');
	const paragraph = parent.querySelector('p');
	paragraph.textContent= errorMessage; 
	
}