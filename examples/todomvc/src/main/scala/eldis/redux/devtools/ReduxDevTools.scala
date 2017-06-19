package eldis.redux.devtools

import scala.scalajs.js
import scala.scalajs.js.annotation._

@js.native
@JSGlobalScope
object ReduxDevTools extends js.Object
{
	@JSName("__REDUX_DEVTOOLS_EXTENSION__")
	val extension: js.UndefOr[ReduxDevToolsExtension] = js.native
}
