package eldis.redux.devtools

import diode.ActionResult.{ModelUpdate, ModelUpdateSilent}
import diode.{ActionProcessor, ActionResult, Dispatcher}
import upickle.default._

import scala.scalajs.js

class ReduxDevToolsActionProcessor[M <: AnyRef]
()
(
	implicit
	reader: Reader[M],
	writer: Writer[M]
)
	extends ActionProcessor[M]
{
	override def process(dispatch: Dispatcher, action: Any, next: (Any) => ActionResult[M], currentModel: M): ActionResult[M] =
	{
		val result = next(action)

		ReduxDevTools.extension.foreach(devTools =>
		{
			val model = result.newModelOpt.getOrElse(currentModel)
			devTools.send(toReduxAction(action), toReduxState(model))
		})

		result
	}

	private def toReduxAction(action: Any): Any =
	{
		val actionName = action.getClass().getSimpleName()
		js.Dynamic.literal(`type` = actionName, full = action.toString)
	}

	private def toReduxState(model: M): Any =
	{
		upickle.json.writeJs(upickle.default.writeJs(model))
	}
}
