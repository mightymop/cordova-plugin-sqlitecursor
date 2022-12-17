var exec = require('cordova/exec');
var PLUGIN_NAME = 'sqlitecursor';

var sqlitecursor = {

	set : function (val, success, error ) {
		exec(success, error, PLUGIN_NAME, 'set', val);
	}
};

module.exports = sqlitecursor;
