package eldis.redux.devtools

import scala.scalajs.js
import scala.scalajs.js.|

@js.native
trait ReduxDevToolsExtension extends js.Object
{
	/*
	send(action, state, [options, instanceId])

	Send a new action and state manually to be shown on the monitor. It's recommended to use connect, unless you want to hook into an already created instance.

	Arguments

	action String (action type) or Object with required type key.
	state any - usually object to expand.
	[options] Object - see the available options.
	[instanceId] String - instance id for which to include the log. If not specified and not present in the options object, will be the first available instance.
	*/

	def send(action: String | Any, state: Any): Unit = js.native
}
