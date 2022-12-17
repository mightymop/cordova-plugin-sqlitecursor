var exec = require('cordova/exec');
var PLUGIN_NAME = 'sqlitecursor';

var sqlitecursor = {

	setSize : function (val, success, error ) {
		exec(success, error, PLUGIN_NAME, 'setSize', [val]);
	}
};

module.exports = sqlitecursor;
