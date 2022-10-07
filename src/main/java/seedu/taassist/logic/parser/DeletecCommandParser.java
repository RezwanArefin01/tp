package seedu.taassist.logic.parser;

import static seedu.taassist.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.taassist.logic.parser.CliSyntax.PREFIX_MODULE_CLASS;

import java.util.List;
import java.util.Set;

import seedu.taassist.logic.commands.DeletecCommand;
import static seedu.taassist.logic.parser.ParserUtil.isPrefixPresent;
import seedu.taassist.logic.parser.exceptions.ParseException;
import seedu.taassist.model.moduleclass.ModuleClass;

/**
 * Parses input arguments and creates a new DeletecCommand object.
 */
public class DeletecCommandParser implements Parser<DeletecCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the DeletecCommand
     * and returns a DeletecCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public DeletecCommand parse(String args) throws ParseException {
        try {
            ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_MODULE_CLASS);
            if (!isPrefixPresent(argMultimap, PREFIX_MODULE_CLASS)) {
                throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeletecCommand.MESSAGE_USAGE));
            }

            List<String> moduleClassStrings = argMultimap.getAllValues(PREFIX_MODULE_CLASS);
            Set<ModuleClass> moduleClasses = ParserUtil.parseModuleClasses(moduleClassStrings);
            return new DeletecCommand(moduleClasses);
        } catch (ParseException pe) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeletecCommand.MESSAGE_USAGE), pe);
        }
    }
}
