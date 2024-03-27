package org.jetbrains.kotlin.course.tamagotchi.game

import org.jetbrains.kotlin.course.tamagotchi.models.Command
import org.jetbrains.kotlin.course.tamagotchi.models.Mode
import org.springframework.stereotype.Service

@Service
class GameService {
    companion object {
        private const val MAX_CAPACITY = 16
    }

    fun addCommand(command: Command): Boolean = if (commands.size < 16) {
        commands.addLast(command)
        true
    } else false

    fun getCommand(mode: Mode): Command? =
        if (mode == Mode.Queue) commands.removeFirstOrNull() else commands.removeLastOrNull()

    val commands: ArrayDeque<Command> = ArrayDeque()
}
