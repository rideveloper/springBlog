
const ver = _.VERSION
console.log(ver);

words = ['a','b','c','d','e','f'];

let fel = _.first(words);
let lel = _.last(words);

console.log('First element : '+fel);
console.log('Last element : '+lel);

function displayMsg(x) {
	console.log(x);
}

for (var x = 0; x < words.length; x++) {
	_.delay(displayMsg,150,words[x]);
	displayMsg("Second "+words[x]);
}

document.addEventListener('DOMContentLoaded', function() {
	var tst = _.debounce(function() {
		xArr = [];
		let checkd = document.querySelectorAll('input[type=checkbox]:checked');
		for (let j = 0; j < checkd.length; j++) {
			xArr.push(checkd[j].value);
		}
		console.log(xArr);
	}, 4500);
						
	let zx = document.getElementsByClassName('cbx');
	console.log(zx);
	for (let i = 0; i < zx.length; i++) {
		zx[i].addEventListener('change',tst);
		}
});